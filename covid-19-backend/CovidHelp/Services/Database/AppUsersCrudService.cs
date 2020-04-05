using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.Database.Services.Repository;
using NetCoreCommons.Database.UnitOfWork;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.DynamicForms.Services;
using NetCoreCommons.Security.Models.Auth;
using CovidHelp.Helpers;
using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using NetCoreCommons.Shared.Helpers;

namespace CovidHelp.Services.Database
{
  [ScopeService]
  public class AppUsersCrudService : AbstractUserCrudService<AppUser, AppUserViewModel, IUserRepository<AppUser>>
  {
    private readonly IDocumentService documentsService;

    public AppUsersCrudService(IDatabaseUnitOfWork uow,
      IEntityFormFieldDefinitionsService entityFormFieldDefinitionsService,
      IConfigService configService,
      IEmailService emailService,
      IDocumentService documentsService) : base(uow, entityFormFieldDefinitionsService, configService, emailService)
    {
      this.documentsService = documentsService;
    }

    protected override bool IsAdmin(AuthenticatedUserViewModel authenticatedUser)
    {
      return SecurityHelper.IsAdmin(authenticatedUser);
    }
    protected override void BeforeAdd(AppUser entity, AuthenticatedUserViewModel authenticatedUser)
    {
      base.BeforeAdd(entity, authenticatedUser);
      VerifyImage(entity, authenticatedUser);
    }
    protected override void BeforeUpdate(AppUser entity, AuthenticatedUserViewModel authenticatedUser)
    {
      base.BeforeUpdate(entity, authenticatedUser);
      VerifyImage(entity, authenticatedUser);
    }

    private void VerifyImage(AppUser entity, AuthenticatedUserViewModel authenticatedUser)
    {
      if (!string.IsNullOrEmpty(entity.UserImage) && ImageHelper.IsBase64StringImage(entity.UserImage))
      {
        entity.UserImage = documentsService.CreateImageFromBase64(entity.UserImage, authenticatedUser).FilePath;
      }
    }

    protected override IEnumerable<Expression<Func<AppUser, object>>> IncludesForGetListRequest(AuthenticatedUserViewModel authenticatedUser)
    {
      return base.IncludesForGetListRequest(authenticatedUser).Append(x => x.Country).Append(x => x.City);
    }
    protected override IEnumerable<Expression<Func<AppUser, object>>> IncludesForGetOneRequest(AuthenticatedUserViewModel authenticatedUser)
    {
      return base.IncludesForGetOneRequest(authenticatedUser).Append(x => x.Country).Append(x => x.City);
    }
  }
}
