using CovidHelp.Models.ViewModels;
using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Web.Controlers;

namespace CovidHelp.Controlers
{
  public class ApiCityController : ApiReadWriteController<long, CityViewModel, ICrudService<CityViewModel>>
  {
    public ApiCityController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
    {
    }
  }
}
