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

namespace CovidHelp.Services.Database
{
  public interface IUserLocationCrudService : ICrudService<UserLocationViewModel>
  {
    IEnumerable<UserLocationViewModel> GetForUser(long userId, AuthenticatedUserViewModel authenticatedUser);
    IEnumerable<UserLocationViewModel> GetForDate(DateTime date, AuthenticatedUserViewModel authenticatedUser);
    Dictionary<DateTime, IEnumerable<UserLocationViewModel>> GetForUserGroupedByDay(long userId, AuthenticatedUserViewModel authenticatedUser);
  }
  [ScopeService]
  public class UserLocationCrudService : AbstractCrudService<UserLocation, UserLocationViewModel,
    IGenericRepository<UserLocation>>, IUserLocationCrudService
  {


    public IEnumerable<UserLocationViewModel> GetForUser(long userId, AuthenticatedUserViewModel authenticatedUser)
    {
      return _repository.GetAll(x => x.UserId == userId).Select(x => MapToViewModel(x));
    }
    protected override UserLocationViewModel MapToViewModel(UserLocation model)
    {
      var result = base.MapToViewModel(model);
      result.Location = GeoHelper.CreatePointViewModelFromPoint(model.Location);
      return result;
    }
    protected override UserLocation MapToModel(UserLocationViewModel viewModel)
    {
      var result = base.MapToModel(viewModel);
      result.Location = GeoHelper.CreatePointFromViewModelPoint(viewModel.Location);
      return result;
    }
    protected override Order GetDefaultOrder()
    {
      return new Order() { IsAscending = true, Property = "Date" };
    }

    public IEnumerable<UserLocationViewModel> GetForDate(DateTime date, AuthenticatedUserViewModel authenticatedUser)
    {
      return _repository.GetAll(x => x.Date == date).Select(x => MapToViewModel(x));
    }

    public Dictionary<DateTime, IEnumerable<UserLocationViewModel>> GetForUserGroupedByDay(long userId, AuthenticatedUserViewModel authenticatedUser)
    {
      var byDate = GetForUser(userId, authenticatedUser);
      return byDate.GroupBy(x => x.Date.Date).ToDictionary(x => x.Key, y => y.AsEnumerable());
    }
  }

}
