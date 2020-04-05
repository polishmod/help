using CovidHelp.Helpers;
using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.Database.Models.PagedList;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.Security.Models.Auth;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;

namespace CovidHelp.Services.Database
{
  public interface IInfectedStatisticsCrudService : ICrudService<InfectedStatisticsViewModel>
  {
    IEnumerable<InfectedStatisticsViewModel> GetStatisticsForDate(DateTime date, AuthenticatedUserViewModel authenticatedUserViewModel);
    IEnumerable<InfectedStatisticsViewModel> GetStatisticsForCountryName(string name, AuthenticatedUserViewModel authenticatedUserViewModel);
  }
  [ScopeService]
  public class InfectesStatisticsCrudService : AbstractCrudService<InfectedStatistics, InfectedStatisticsViewModel,
      IGenericRepository<InfectedStatistics>>, IInfectedStatisticsCrudService
  {
    protected override InfectedStatisticsViewModel MapToViewModel(InfectedStatistics model)
    {
      var result = base.MapToViewModel(model);
      result.CountryLocation = GeoHelper.CreatePointViewModelFromPoint(model.Country?.Location);
      return result;
    }
    protected override IEnumerable<Expression<Func<InfectedStatistics, object>>> IncludesForGetListRequest(AuthenticatedUserViewModel authenticatedUser)
    {
      return base.IncludesForGetListRequest(authenticatedUser).Append(x => x.Country);
    }
    public IEnumerable<InfectedStatisticsViewModel> GetStatisticsForCountryName(string name, AuthenticatedUserViewModel authenticatedUserViewModel)
    {
      return _repository.GetAll(x => x.Country.Name.ToLower() == name.ToLower()).Select(x => MapToViewModel(x));
    }

    public IEnumerable<InfectedStatisticsViewModel> GetStatisticsForDate(DateTime date, AuthenticatedUserViewModel authenticatedUserViewModel)
    {
      return _repository.GetAll(x => x.Date == date).Select(x => MapToViewModel(x));
    }

    protected override Order GetDefaultOrder()
    {
      return new Order()
      {
        IsAscending = true,
        Property = "Date"
      };
    }
  }
}
