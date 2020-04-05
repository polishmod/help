using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.DI.Attributes;


namespace CovidHelp.Services.Database
{
  public interface ICityCrudService : ICrudService<CityViewModel>
  {

  }
  [ScopeService]
  public class CityCrudService : AbstractCrudService<City, CityViewModel, IGenericRepository<City>>, ICityCrudService
  {
    protected override City MapToModel(CityViewModel viewModel)
    {
      return base.MapToModel(viewModel);
    }
    protected override CityViewModel MapToViewModel(City model)
    {
      return base.MapToViewModel(model);
    }
  }
}
