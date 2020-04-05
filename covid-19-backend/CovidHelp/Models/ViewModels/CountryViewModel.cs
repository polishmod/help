using NetCoreCommons.DynamicForms.Attributes;
using NetCoreCommons.Shared.Models;

namespace CovidHelp.Models.ViewModels
{
  public class CountryViewModel : BaseViewModel<long>
  {
    public string Code { get; set; }
    public string Name { get; set; }
    [FormDisplay(DisplayNever = true, PredefinedInputType = NetCoreCommons.DynamicForms.Models.InputType.Geolocation)]
    public GeoPointViewModel Location { get; set; }

    public override string OptionText => Name;
  }
}
