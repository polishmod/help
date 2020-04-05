using CovidHelp.Models.ViewModels;
using CovidHelp.Services.Database;
using Microsoft.AspNetCore.Authorization;
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
  [AllowAnonymous]
  public class ApiInfectedStatisticsController : ApiReadWriteController<long, InfectedStatisticsViewModel, IInfectedStatisticsCrudService>
  {
    public ApiInfectedStatisticsController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
    {
    }

    [HttpGet]
    [RouteAction]
    [Produces("application/json")]
    [ProducesResponseType(200)]
    [ProducesResponseType(typeof(ErrorApiResponse), 401)]
    public virtual ApiResponse<IEnumerable<InfectedStatisticsViewModel>> GetForDate(DateTime date)
    {
      return OkResponse(this._service.GetStatisticsForDate(date, AuthenticatedUser));
    }
  }
}
