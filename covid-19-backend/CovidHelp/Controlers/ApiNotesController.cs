using Microsoft.Extensions.Caching.Memory;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.Shared.Models;
using NetCoreCommons.Web.Controlers;

namespace CovidHelp.Controlers
{
    public class ApiNotesController : AbstractNotesController<NoteViewModel>
    {
        public ApiNotesController(IMemoryCache cache, ICrudServiceUnitOfWork unitOfWork) : base(cache, unitOfWork)
        {
        }
    }
}
