using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.DynamicForms.Models;
using NetCoreCommons.Security.Models.Auth;
using System.Collections.Generic;
using System.Linq;

namespace CovidHelp.Services.Database
{
  public interface IFirebaseNotificationCrudService : ICrudService<FirebaseNotificationViewModel>
  {
    IEnumerable<FirebaseNotificationViewModel> GetAllToSend(AuthenticatedUserViewModel authenticatedUserViewModel);
  }
  [ScopeService]
  public class FirebaseNotificationCrudService : AbstractCrudService<FirebaseNotification, FirebaseNotificationViewModel, IGenericRepository<FirebaseNotification>>, IFirebaseNotificationCrudService
  {
    public IEnumerable<FirebaseNotificationViewModel> GetAllToSend(AuthenticatedUserViewModel authenticatedUserViewModel)
    {
      return _repository.GetAll(x => x.DateSend == null).Select(x => MapToViewModel(x));
    }

    public override FormModel<FirebaseNotificationViewModel> GetWithEditDataById<TID>(TID id, Dictionary<string, string> additionalParams, AuthenticatedUserViewModel authenticatedUser)
    {
      return base.GetWithEditDataById(id, additionalParams, authenticatedUser);
    }
  }
}
