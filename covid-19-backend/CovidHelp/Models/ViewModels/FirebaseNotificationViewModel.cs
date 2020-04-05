using CovidHelp.Models.Entities;
using NetCoreCommons.DynamicForms.Attributes;
using NetCoreCommons.Shared.Models;
using System;

namespace CovidHelp.Models.ViewModels
{
  public class FirebaseNotificationViewModel : BaseViewModel<long>
  {
    public string Title { get; set; }
    public string Message { get; set; }
    public FirebaseNotificationTypeEnum Type { get; set; }
    [FormDisplay(EditableOnEditForm = false)]
    [FormOneToManyAssociationAttribute(AssociationType = typeof(AppUserViewModel))]
    public long FromUserId { get; set; }
    [FormDisplay(EditableOnEditForm = false)]
    [FormOneToManyAssociationAttribute(AssociationType = typeof(AppUserViewModel))]
    public long ToUserId { get; set; }
    [FormDisplay(Editable = false, DisplayOnCreationForm = false)]
    public DateTime? DateSend { get; set; }

    public override string OptionText => Title;
  }
}
