using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DynamicForms.Models;
using NetCoreCommons.DynamicForms.Services;
using NetCoreCommons.Shared.Helpers;
using NetCoreCommons.Web.Attributes;
using NetCoreCommons.Web.Controlers;
using NetCoreCommons.Web.Models;
using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using System.Linq;

namespace CovidHelp.Controlers
{
    public class ApiConfigController : AbstractConfigController
    {
        public ApiConfigController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork, IEntityFormFieldDefinitionsService entityFormService) : base(cache, unitOfWork, entityFormService)
        {
        }

        [HttpGet]
        [RouteAction]
        [Produces("application/json")]
        [ProducesResponseType(200)]
        [ProducesResponseType(typeof(ErrorApiResponse), 400)]
        [ProducesResponseType(typeof(ErrorApiResponse), 401)]
        [ProducesResponseType(typeof(ErrorApiResponse), 500)]
        public ApiResponse<ConfigAppViewModel> Config() => OkResponse(new ConfigAppViewModel()
        {
            Version = "1.0.0",
            Models = EnumHelper.GetAllAsList<ModelTypes>(typeof(ModelTypes))
             .Select(x => new ModelFieldDefinitionViewModel() {
                 FieldDefinitions = EntityFormService.GetModelFieldsDefinitions(x.ToString(), AuthenticatedUser),
                 ModelType = x.ToString()
             })
             .ToList()

        });

    }
}
