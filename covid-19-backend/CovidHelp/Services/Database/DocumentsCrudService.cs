using NetCoreCommons.Database.Models;
using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.DynamicForms.Services;
using NetCoreCommons.Shared.Extensions;
using NetCoreCommons.Shared.Models;

namespace CovidHelp.Services.Database
{
    [ScopeService]
    public class DocumentsCrudService : AbstractDocumentCrudService
    {
        public DocumentsCrudService(IDatabaseUnitOfWork uow, IEntityFormFieldDefinitionsService entityFormFieldDefinitionsService) : base(uow, entityFormFieldDefinitionsService)
        {
        }

    }
}
