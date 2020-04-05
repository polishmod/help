using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Security.Services;
using NetCoreCommons.Web.Controlers;
using CovidHelp.Models.ViewModels;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using NetCoreCommons.Web.Attributes;
using NetCoreCommons.Web.Models;
using CovidHelp.Services.Auth;

namespace CovidHelp.Controlers
{
    public class ApiAuthenticationController : AbstractAuthController<AppUserViewModel>
    {

        public ApiAuthenticationController(IMemoryCache cache, IAuthenticationService authenticationService) : base(cache, authenticationService)
        {

        }

    [AllowAnonymous]
    [HttpPost]
    [RouteAction]
    [Produces("application/json")]
    [ProducesResponseType(200)]
    [ProducesResponseType(typeof(ErrorApiResponse), 400)]
    [ProducesResponseType(typeof(ErrorApiResponse), 401)]
    [ProducesResponseType(typeof(ErrorApiResponse), 500)]
    public virtual ApiResponse<string> RegisterAnonymous([FromBody] AnonymousRegistrationViewModel registrationViewModel) => OkResponse((AuthenticationService as AppAuthenticationService).RegisterAnonymous(registrationViewModel));


  }
}
