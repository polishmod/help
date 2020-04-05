using CovidHelp.Helpers;
using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.Security.Models.Auth;

namespace CovidHelp.Services.Database
{
  public interface ICountryCrudService : ICrudService<CountryViewModel>
  {
    CountryViewModel GetByName(string name, AuthenticatedUserViewModel authenticatedUserViewModel);
  }
  [ScopeService]
  public class CountryCrudService : AbstractCrudService<Country, CountryViewModel, IGenericRepository<Country>>, ICountryCrudService
  {
    public CountryViewModel GetByName(string name, AuthenticatedUserViewModel authenticatedUserViewModel)
    {
      return MapToViewModel(_repository.FirstOrDefault(x => x.Name == name));
    }
    protected override CountryViewModel MapToViewModel(Country model)
    {
      var result =  base.MapToViewModel(model);
      result.Location = GeoHelper.CreatePointViewModelFromPoint(model.Location);
      return result;
    }
    protected override Country MapToModel(CountryViewModel viewModel)
    {
      var result = base.MapToModel(viewModel);
      result.Location = GeoHelper.CreatePointFromViewModelPoint(viewModel.Location);
      return result;
    }
  }
}
