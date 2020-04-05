using CovidHelp.Models.ViewModels;
using CovidHelp.Services.Database;
using CovidHelp.Services.Integrations;
using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.Security.Services;
using NetCoreCommons.Shared.Services;
using System;
using System.Linq;

namespace CovidHelp.Services.Schedules
{
  [TransientService]
  public class FirebaseNotificationsScheduler : AbstractScheduleJob
  {
    private readonly IFirebaseNotificationCrudService firebaseNotificationCrudService;
    private readonly IUsersService<AppUserViewModel> usersService;

    public FirebaseNotificationsScheduler(IAuthenticationService authenticationService,
      IFirebaseNotificationCrudService firebaseNotificationCrudService,
      IUsersService<AppUserViewModel> usersService) : base(authenticationService)
    {
      this.firebaseNotificationCrudService = firebaseNotificationCrudService;
      this.usersService = usersService;
    }

    protected override void ExecuteJob()
    {
      var notifications = firebaseNotificationCrudService.GetAllToSend(GetUserForScheduleJob()).ToList();
      notifications.ForEach(x =>
      {
        if (FirebaseService.SendNotifiction(x, GetUserForScheduleJob()))
        {
          x.DateSend = DateTime.Now;
          firebaseNotificationCrudService.Update(x, GetUserForScheduleJob());
        }
      });
    }
  }
}
