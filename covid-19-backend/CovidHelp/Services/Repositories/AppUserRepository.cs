using NetCoreCommons.Database.Services;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.DI.Attributes;
using CovidHelp.Models.Entities;

namespace CovidHelp.Services.Repositories
{
    [Repository]
    public class AppUserRepository : AbstractUserRepository<AppUser>
    {
        public AppUserRepository(AbstractDbContext context) : base(context)
        {
        }
    }
}
