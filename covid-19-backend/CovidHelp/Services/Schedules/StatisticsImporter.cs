using CovidHelp.Models.Entities;
using CovidHelp.Services.Database;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.Security.Services;
using NetCoreCommons.Shared.Extensions;
using NetCoreCommons.Shared.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;

namespace CovidHelp.Services.Schedules
{
  public class DataSet
  {
    public DateTime Date { get; set; }
    public long Confirmed { get; set; }
    public long Deaths { get; set; }
    public long Recovered { get; set; }
  }
  [TransientService]
  public class StatisticsImporter : AbstractScheduleJob
  {

    private readonly ICountryCrudService countryService;
    private readonly IDatabaseUnitOfWork uow;

    public StatisticsImporter(IAuthenticationService authenticationService,

      ICountryCrudService countryService,
      IDatabaseUnitOfWork uow) : base(authenticationService)
    {

      this.countryService = countryService;
      this.uow = uow;
    }

    protected override void ExecuteJob()
    {
      using (WebClient wc = new WebClient())
      {
        var json = wc.DownloadString("https://pomber.github.io/covid19/timeseries.json");
        var parsedData = json.FromJson<Dictionary<string, DataSet[]>>();
        // iterate over all and verify if exists
        parsedData.ForEach(x =>
        {
          var countryName = x.Key.ToLower();

          var infectesStatisticsRepository = uow.RepositoryByModel<InfectedStatistics>();
          var allStatisticsForCountry = infectesStatisticsRepository.GetAll(stats => stats.Country.Name.ToLower() == countryName).ToList();

          var country = countryService.GetByName(x.Key, GetUserForScheduleJob());
          if (country == null)
          {
            ApplicationLogger.LogDebug(this, $"Country not exists {x.Key} for import statistics job");
          }
          else
          {
            x.Value.ForEach(daily =>
            {
              var currentStats = allStatisticsForCountry.FirstOrDefault(y => y.Date.Date == daily.Date.Date);
              if (currentStats == null)
              {
                infectesStatisticsRepository.Add(new InfectedStatistics()
                {
                  Date = daily.Date,
                  CountryId = country.Id,
                  Confirmed = daily.Confirmed,
                  Deaths = daily.Deaths,
                  Recovered = daily.Recovered,
                  Guid = Guid.NewGuid()
                });
              }
              else if (currentStats.Deaths != daily.Deaths ||
                      currentStats.Confirmed != daily.Confirmed ||
                      currentStats.Recovered != daily.Recovered
              )
              {
                currentStats.Deaths = daily.Deaths;
                currentStats.Confirmed = daily.Confirmed;
                currentStats.Recovered = daily.Recovered;
              }


            });
          }
          uow.SaveChanges(GetUserForScheduleJob());


        });

      }
    }


  }
}


