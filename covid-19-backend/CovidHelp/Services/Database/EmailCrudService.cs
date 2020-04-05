using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.DynamicForms.Services;

namespace CovidHelp.Services.Database
{
    [ScopeService]
    public class EmailCrudService : AbstractEmailCrudService
    {
        public EmailCrudService(IDatabaseUnitOfWork uow, IEntityFormFieldDefinitionsService entityFormFieldDefinitionsService) : base(uow, entityFormFieldDefinitionsService)
        {
        }
    }
}
