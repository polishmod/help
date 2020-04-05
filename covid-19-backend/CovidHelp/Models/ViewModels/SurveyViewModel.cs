using CovidHelp.Models.Entities;
using NetCoreCommons.DynamicForms.Attributes;
using NetCoreCommons.DynamicForms.Models;
using NetCoreCommons.Shared.Helpers;
using NetCoreCommons.Shared.Models;
using System;

namespace CovidHelp.Models.ViewModels
{
  public class SurveyViewModel : BaseViewModel<long>
  {
    [FormDisplay(EditableOnEditForm =  false)]
    [FormOneToManyAssociationAttribute(AssociationType = typeof(AppUserViewModel))]
    public long UserId { get; set; }
    [FormDisplay(EditableOnEditForm = false, PredefinedInputType = InputType.Date)]
    public DateTime Date { get; set; }
    public double Temperature { get; set; }
    [FormDisplay(FieldText =  "Have you returned from abroad within the last 14 days ? ")]
    public PeriodStatusEnum ReturnedFromAbroad { get; set; }
    [FormDisplay(FieldText = "Have you had close contact with or cared for someone diagnosed with COVID-19 within the last 14 days?")]
    public PeriodStatusEnum HadCloseContactToDiagnosed { get; set; }
    [FormDisplay(FieldText = "Have you been in close contact with anyone who has traveled within the last 14 days to one of the countries in risk list?")]

    public PeriodStatusEnum HadCloseContactDuringTravel { get; set; }
    [FormDisplay(FieldText = "Have you been obeying strict hygiene rules and using personal protective equipment?")]

    public HygeneStatusEnum ObeyToHygieneRules { get; set; }
    [FormDisplay(FieldText = "Have you experienced any cold or flu-like symptoms in the last 14 days (to include fever, cough, difficulty breathing, sore throat, respiratory illness)?")]

    public HealthStatusEnum HadSymptoms { get; set; }

    public override string OptionText => FormattingHelper.GetFormattedDateTime(Date);
  }
}