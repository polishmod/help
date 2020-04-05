using CovidHelp.Models.ViewModels;
using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Web.Controlers;

namespace CovidHelp.Controlers
{
  public class ApiCountryController : ApiReadWriteController<long, CountryViewModel, ICrudService<CountryViewModel>>
  {
    public ApiCountryController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
    {
    }
  }
}
