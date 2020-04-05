using NetCoreCommons.Security.Models.Auth;
using NetCoreCommons.Shared.Helpers;
using CovidHelp.Models.Entities;
using System.Linq;

namespace CovidHelp.Helpers
{
    public static class SecurityHelper
    {

        public static bool IsAdmin(AuthenticatedUserViewModel user)
        {
            return IsRole(user, AppUserRoleEnum.Admin);
        }
        public static bool IsRole(AuthenticatedUserViewModel user, AppUserRoleEnum role)
        {
            var roles = user.Roles.Select(x => EnumHelper.GetValueForString<AppUserRoleEnum>(x));
            return roles.Contains(role);
        }


    }
}
