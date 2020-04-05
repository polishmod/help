using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.Security.Models.Auth;
using NetCoreCommons.Security.Services;
using NetCoreCommons.Shared.Helpers;
using System;

namespace CovidHelp.Services.Auth
{
  [ScopeService]
  public class AppAuthenticationService : BaseAuthenticationService<AppUser, AppUserViewModel>
  {
    private readonly IConfigService configService;


    public AppAuthenticationService(IDatabaseUnitOfWork _databaseUnitOfWork,
        IUsersService<AppUserViewModel> usersService,
        IConfigService configService
        ) : base(_databaseUnitOfWork, usersService)
    {
      this.configService = configService;
    }

    public override AuthenticatedUserViewModel GetUserForScheduleJob()
    {
      return null;
    }
    public string RegisterAnonymous(AnonymousRegistrationViewModel registrationViewModel)
    {

      var newUser = new RegisterUserViewModel()
      {
        Phone = "",
        Password = RandomHelper.RandomString(10,true),
        FirstName = "",
        LastName = "",
        Email = $"anonymous_{DateTime.Now.Year}_{DateTime.Now.Month}_{DateTime.Now.Day}_{RandomHelper.RandomNumber(0, 9, 4)}@covidhelp.com"
      };
      var user = UsersService.Register(newUser);
      user.IsAnonymous = true;
      UsersService.Update(user, GetUserForScheduleJob());
      return Authenticate(new AuthenticateUserViewModel()
      {
        Email = newUser.Email,
        Password = newUser.Password,
        Phone = newUser.Phone
      });
    }
    protected override void VerifyUserCanLoginAsOtherUser(long userId, AuthenticatedUserViewModel authenticatedUser)
    {

    }


  }
}
