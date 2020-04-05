using CovidHelp.Models.Entities;
using NetCoreCommons.DynamicForms.Attributes;
using NetCoreCommons.DynamicForms.Models;
using NetCoreCommons.Shared.Models;
using System;
using System.Collections.Generic;

namespace CovidHelp.Models.ViewModels
{

  [FormConfig(FormGroupLayoutComponent = FormGroupLayoutComponent.CARD, FormGroupLayout = FormLayout.TWO, HideDefaultFormGroup = true)]
  [FormGroupConfig(Name = "UserImage", Order = 1, FormLayout = FormLayout.TWO)]
  [FormGroupConfig(Name = "Personal info", EditFields = new string[] { "FirstName", "LastName", "DateOfBirth", "Sex" }, Order = 2, FormLayout = FormLayout.TWO)]
  [FormGroupConfig(Name = "Localisation", EditFields = new string[] { "CountryName", "CityName" }, Order = 3, FormLayout = FormLayout.TWO)]
  [FormGroupConfig(Name = "Health", EditFields = new string[] { "DoctorId", "UserHealthStatus" }, Order = 4, FormLayout = FormLayout.TWO)]

  public class AppUserViewModel : BaseUserViewModel
  {

    [FormDisplay(PredefinedInputType = InputType.Select, Required = true)]
    [FormOneToManyAssociationAttribute(AssociationType = typeof(Sex))]
    public Sex Sex { get; set; }
    [FormDisplay(Display = false)]

    [FormManyToManyAssociationAttribute(AssociationType = typeof(AppUserRoleEnum))]
    public List<string> Roles { get; set; }
    [FormDisplay(PredefinedInputType = InputType.Date)]
    public DateTime DateOfBirth { get; set; }


    [FormDisplay(FieldText = "Country", TableText = "Country", Filterable = false)]
    public string CountryName { get; set; }
    public long? CountryId { get; set; }
    [FormDisplay(FieldText = "City", TableText = "City", Filterable = false)]
    public string CityName { get; set; }
    [FormOneToManyAssociationAttribute(AssociationType = typeof(UserHealthStatus))]
    [FormDisplay(PredefinedInputType = InputType.Radio, Required = true)]
    public UserHealthStatus UserHealthStatus { get; internal set; }
    [FormOneToManyAssociationAttribute(AssociationType = typeof(AppUserViewModel))]
    public long? DoctorId { get; set; }
    [FormDisplay(PredefinedInputType = InputType.Image, GroupName = "UserImage", Display = false)]
    public string UserImage { get; set; }
    [FormDisplay(EditableOnEditForm = false)]
    public bool IsAnonymous { get; set; }
    public AppUserViewModel()
    {
    }

  }
}
