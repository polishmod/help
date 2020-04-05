using CovidHelp.Helpers;
using CovidHelp.Models.Entities;
using NetCoreCommons.Helpers.Security;
using NetCoreCommons.Security.Models.Auth;
using NetCoreCommons.Shared.Extensions;
using NetCoreCommons.Shared.Helpers;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace CovidHelp.Database
{
  public static class DatabaseSeedExtensions
  {

    public static Task SeedRandomUserLocation(this DatabaseContext context)
    {
      return Task.Run(() =>
      {
        if (!context.UserLocations.Any())
        {
          var dirPath = Path.Combine(FileHelper.AppDataFolder(), "AppFiles");
          var allPoints = new List<List<string>>();
          allPoints.Add(File.ReadAllLines(Path.Combine(dirPath, "track_points.csv")).Skip(1).ToList());
          allPoints.Add(File.ReadAllLines(Path.Combine(dirPath, "track_points_1.csv")).Skip(1).ToList());
          allPoints.Add(File.ReadAllLines(Path.Combine(dirPath, "track_points_2.csv")).Skip(1).ToList());

          var users = context.Users.ToList();
          users.ForEach(user =>
          {
            var startDate = DateTime.Now.AddDays(-14);
            startDate = new DateTime(startDate.Year, startDate.Month, startDate.Day, startDate.Hour, 0, 0);
            var userRoute = allPoints[RandomHelper.RandomNumber(0, allPoints.Count)];
            var currentPoint = 0;
            while (startDate < DateTime.Now)
            {
              var rawPoint = userRoute[currentPoint++ % userRoute.Count].Split(",");
              var lat = ParsingHelper.GetDouble(rawPoint[1].Replace(".",",")) + RandomHelper.RandomDouble(0, 1);
              var lon = ParsingHelper.GetDouble(rawPoint[0].Replace(".", ",")) + RandomHelper.RandomDouble(0, 1);
              context.UserLocations.Add(new UserLocation()
              {
                CountryId = user.CountryId,
                CityId = user.CityId,
                Location = GeoHelper.CreatePointFromLatLon(lat, lon),
                UserId = user.Id,
                Date = startDate,
                GroupTimestamp = startDate.Ticks
              });
              startDate = startDate.AddHours(1);
            }
          });
        }
        context.SaveChanges();
      });
    }
    public static Task SeedRandomUsers(this DatabaseContext context, bool onlyForPl)
    {
      return Task.Run(() =>
      {
        if (context.Users.Count() < 5)
        {
          var numberOfUsers = 100;
          var numberOfDoctors = numberOfUsers / 10;
          var boyNames = HttpHelper.ReadRemoteJson<List<string>>($"http://names.drycodes.com/{numberOfUsers}?nameOptions=boy_names");
          var girlNames = HttpHelper.ReadRemoteJson<List<string>>($"http://names.drycodes.com/{numberOfUsers}?nameOptions=girl_names");
          // curently generate only for poland
          var cSet = context.Cities.AsQueryable();
          if (onlyForPl)
          {
            cSet = cSet.Where(x => x.Country.Code == "PL");
          }
          var cities = cSet.ToList();
          var doctors = Enumerable.Range(0, numberOfDoctors).Select(x => GenerateAndAddRandomUserWithRole(context, boyNames, girlNames, cities, AppUserRoleEnum.Doctor)).ToList();
          context.SaveChanges();
          Enumerable.Range(0, numberOfUsers).ForEach(x =>
          {
            var user = GenerateAndAddRandomUserWithRole(context, boyNames, girlNames, cities, AppUserRoleEnum.Patient);
            user.DoctorId = doctors[RandomHelper.RandomNumber(0, doctors.Count)].Id;
          });
          context.SaveChanges();
        }
      });
    }

    public static AppUser GenerateAndAddRandomUserWithRole(
      this DatabaseContext context,
        List<string> boyNames,
       List<string> girlNames,
       List<City> cities,
      AppUserRoleEnum role)
    {
      var isBoy = RandomHelper.RandomNumber(1, 10) > 5;
      var name = isBoy ? boyNames[RandomHelper.RandomNumber(0, boyNames.Count)] : boyNames[RandomHelper.RandomNumber(0, girlNames.Count)];
      var city = cities[RandomHelper.RandomNumber(0, cities.Count)];
      var healtStatusValues = EnumHelper.GetAllAsList<UserHealthStatus>(typeof(UserHealthStatus)).ToList();
      var healthStatus = role == AppUserRoleEnum.Patient ? healtStatusValues[RandomHelper.RandomNumber(0, healtStatusValues.Count)] : UserHealthStatus.Healthy;
      var user = new AppUser()
      {
        Guid = Guid.NewGuid(),
        FirstName = name.Split("_")[0],
        LastName = name.Split("_")[1],
        Password = CryptoHelper.CreateHash("test1234"),
        Email = $"{name}@covid-{RandomHelper.RandomString(4, true)}.com",
        DateOfBirth = DateTime.Now.AddYears(-RandomHelper.RandomNumber(10, 60)),
        Sex = isBoy ? Sex.Male : Sex.Female,
        Status = UserStatusEnum.Active,
        Phone = RandomHelper.RandomNumber(1, 9, 9) + "",
        CountryId = city.CountryId,
        CityId = city.Id,
        UserHealthStatus = healthStatus,
        Roles = new string[] { role.ToString() },
      };
      context.Users.Add(user);
      return user;
    }
    public static Task SeedCities(this DatabaseContext context, bool loadOnlyPl = true)
    {
      return Task.Run(() =>
      {
        if (!context.Cities.Any())
        {
          var countries = context.Countries.ToList();
          var cities = HttpHelper.ReadRemoteJson<List<Dictionary<string, string>>>($"https://raw.githubusercontent.com/lutangar/cities.json/master/cities.json");
          if (loadOnlyPl)
          {
            cities = cities.Where(city => city["country"].EqualsAnyIgnoreCase("PL")).ToList();
          }
          cities.ForEach(city =>
          {
            var name = city["name"];
            var country_code = city["country"];
            var lat = ParsingHelper.GetDouble(city["lat"]);
            var lon = ParsingHelper.GetDouble(city["lng"]);
            var country = countries.FirstOrDefault(x => x.Code.EqualsAnyIgnoreCase(country_code));
            if (country != null)
            {
              var cc = new City()
              {
                Name = name,
                CountryId = country.Id,
                Location = GeoHelper.CreatePointFromLatLon(lat, lon),
                Guid = Guid.NewGuid()
              };
              context.Cities.Add(cc);

            }
            else
            {
              Console.WriteLine("Coutnry not found " + country_code);
            }

          });
          context.SaveChanges();
        }
      });
    }

    public static Task SeedCountries(this DatabaseContext context)
    {
      return Task.Run(() =>
      {
        if (!context.Countries.Any())
        {
          var countries = HttpHelper.ReadRemoteJson<List<Dictionary<string, dynamic>>>($"https://gist.githubusercontent.com/erdem/8c7d26765831d0f9a8c62f02782ae00d/raw/248037cd701af0a4957cce340dabb0fd04e38f4c/countries.json");
          countries.ForEach(country =>
          {
            var name = country["name"];
            var country_code = country["country_code"];
            var rawLocation = country["latlng"];
            var cc = new Country()
            {
              Name = name,
              Code = country_code,
              Location = GeoHelper.CreatePointFromLatLon(rawLocation.First.Value, rawLocation.Last.Value),
              Guid = Guid.NewGuid()
            };
            context.Countries.Add(cc);

          });
          context.SaveChanges();
        }
      });


    }

    public static Task SeedDefaultAppUsers(this DatabaseContext context)
    {
      return Task.Run(() =>
      {
        var adminUser = context.Users.Find(1L);
        var serviceUser = context.Users.Find(2L);
        if (adminUser != null && serviceUser != null)
        {
          return;
        }

        if (adminUser == null)
        {
          var userModel = new AppUser
          {
            FirstName = "Administrator",
            LastName = "Administrator",
            Email = "admin@wat.edu.pl",
            Password = CryptoHelper.CreateHash("admin"),
            Roles = new string[] { AppUserRoleEnum.Admin.ToString() },
            Status = UserStatusEnum.Active
          };
          context.Users.Add(userModel);
        }

        if (serviceUser == null)
        {
          var userModel = new AppUser
          {
            FirstName = "Service",
            LastName = "AdminHangfireistrator",
            Email = AppConstants.HANGFIRE_USER_LOGIN,
            Password = CryptoHelper.CreateHash(AppConstants.HANGFIRE_USER_PASSWORD),
            Roles = new string[] { AppUserRoleEnum.Admin.ToString() },
            Status = UserStatusEnum.Active
          };
          context.Users.Add(userModel);
        }
        context.SaveChanges();
      });
    }


  }
}
