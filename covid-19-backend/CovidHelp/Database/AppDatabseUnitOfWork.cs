using Microsoft.AspNetCore.Http;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DI.Attributes;

namespace CovidHelp.Database
{
    [ScopeService]
    public class AppDatabseUnitOfWork : AbstractHttpDatabaseUnitOfWork
    {
        public AppDatabseUnitOfWork(DatabaseContext context, IHttpContextAccessor httpAccessor) : base(context, httpAccessor)
        {
        }
    }
}
