using CovidHelp.Models.ViewModels;
using CovidHelp.Services.Database;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Web.Attributes;
using NetCoreCommons.Web.Controlers;
using NetCoreCommons.Web.Models;
using System;
using System.Collections.Generic;

namespace CovidHelp.Controlers
{
  public class ApiUserLocationController : ApiReadWriteController<long, UserLocationViewModel, IUserLocationCrudService>
  {
    public ApiUserLocationController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
    {

    }

    [HttpGet]
    [RouteAction]
    [Produces("application/json")]
    [ProducesResponseType(200)]
    [ProducesResponseType(typeof(ErrorApiResponse), 401)]
    public virtual ApiResponse<IEnumerable<UserLocationViewModel>> GetForUser(long userId)
    {
      return OkResponse(this._service.GetForUser(userId, AuthenticatedUser));
    }

    [HttpGet]
    [RouteAction]
    [Produces("application/json")]
    [ProducesResponseType(200)]
    [ProducesResponseType(typeof(ErrorApiResponse), 401)]
    public virtual ApiResponse<Dictionary<DateTime, IEnumerable<UserLocationViewModel>>> GetForUserGroupedByDay(long userId)
    {
      return OkResponse(this._service.GetForUserGroupedByDay(userId, AuthenticatedUser));
    }
    [HttpGet]
    [RouteAction]
    [Produces("application/json")]
    [ProducesResponseType(200)]
    [ProducesResponseType(typeof(ErrorApiResponse), 401)]
    public virtual ApiResponse<IEnumerable<UserLocationViewModel>> GetForDate(DateTime date)
    {
      return OkResponse(this._service.GetForDate(date, AuthenticatedUser));
    }

  }
}
