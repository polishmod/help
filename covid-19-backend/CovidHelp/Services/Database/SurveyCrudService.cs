using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.DI.Attributes;

namespace CovidHelp.Services.Database
{
  public interface ISurveyCrudService : ICrudService<SurveyViewModel>
  {

  }
  [ScopeService]
  public class SurveyCrudService : AbstractCrudService<Survey, SurveyViewModel, IGenericRepository<Survey>>, ISurveyCrudService
  {
  }
}
