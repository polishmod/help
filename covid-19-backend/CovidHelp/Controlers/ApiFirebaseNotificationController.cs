using CovidHelp.Models.ViewModels;
using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Web.Controlers;

namespace CovidHelp.Controlers
{
  public class ApiFirebaseNotificationController : ApiReadWriteController<long, FirebaseNotificationViewModel, ICrudService<FirebaseNotificationViewModel>>
  {
    public ApiFirebaseNotificationController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
    {
    }
  }
}