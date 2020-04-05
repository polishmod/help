using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetCoreCommons.DI.Attributes;
using NetCoreCommons.DynamicForms.Services;
using NetCoreCommons.Shared.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace CovidHelp.Services
{
  [ScopeService]
  public class EntityFieldDefinitionMapper : DefaultEntityFormFieldDefinitionModelMapperService
  {

    private static Dictionary<string, Type> MAPPINGS = new Dictionary<string, Type>() {
            {ModelTypes.User.ToString().ToLower(),typeof(AppUserViewModel) },
            {ModelTypes.Note.ToString().ToLower(),typeof(NoteViewModel) },
            {ModelTypes.Survey.ToString().ToLower(),typeof(SurveyViewModel) },
            {ModelTypes.Document.ToString().ToLower(),typeof(DocumentViewModel) },
            {ModelTypes.UserLocation.ToString().ToLower(),typeof(UserLocationViewModel) },
            {ModelTypes.City.ToString().ToLower(),typeof(InfectedStatisticsViewModel) },
            {ModelTypes.Country.ToString().ToLower(),typeof(CountryViewModel) },
            {ModelTypes.FirebaseNotification.ToString().ToLower(),typeof(FirebaseNotificationViewModel) },
        };
    public EntityFieldDefinitionMapper()
    {
    }

    protected override Dictionary<Type, string> GetModelMappings()
    {
      return MAPPINGS.ToDictionary(x => x.Value, x => x.Key);
    }


  }
}
