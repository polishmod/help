using NetCoreCommons.DynamicForms.Attributes;
using NetCoreCommons.Shared.Models;
using System;

namespace CovidHelp.Models.ViewModels
{
  public class UserLocationViewModel : BaseViewModel<long>
  {

    public GeoPointViewModel Location { get; set; }
    public double Precision { get; set; }

    public DateTime Date { get; set; }
    // do grupowania po czasie
    public long GroupTimestamp { get; set; }
    // do raportowania po miescie
    [FormOneToManyAssociationAttribute(AssociationType = typeof(CityViewModel))]
    public long? CityId { get; set; }
    [FormOneToManyAssociationAttribute(AssociationType = typeof(CountryViewModel))]
    // do raportowania po kraju
    // redundancja ale za to latwiej w filtrach
    public long? CountryId { get; set; }
    [FormOneToManyAssociationAttribute(AssociationType = typeof(AppUserViewModel))]
    public long UserId { get; set; }
    public override string OptionText => $"{Date} {Location}";
  }
}
