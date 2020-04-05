using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Web.Controlers;

namespace CovidHelp.Controlers
{
    public class ApiDocumentsController : AbstractDocumentsController
    {
        public ApiDocumentsController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
        {
        }
    }
}
