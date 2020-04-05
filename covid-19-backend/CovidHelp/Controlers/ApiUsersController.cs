using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Web.Controlers;
using NetCoreCommons.Web.Models;
using CovidHelp.Models.ViewModels;


namespace CovidHelp.Controlers
{
    public class ApiUsersController : AbstractUsersController<AppUserViewModel>
    {
        public ApiUsersController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
        {
        }

    public override ApiResponse<AppUserViewModel> GetMyAccount()
    {
      return base.GetMyAccount();
    }
  }
}
