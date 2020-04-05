using NetCoreCommons.Database.Models;
using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.Shared.Models;

namespace CovidHelp.Services.Database
{
    [ScopeService]
    public class AppLogCrudService : AbstractAppLogCrudService<AppLogEntity, AppLogViewModel>
    {
        public AppLogCrudService()
        {
        }
    }
}
