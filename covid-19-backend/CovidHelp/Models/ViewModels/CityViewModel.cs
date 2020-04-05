using NetCoreCommons.DynamicForms.Attributes;
using NetCoreCommons.Shared.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidHelp.Models.ViewModels
{
  public class CityViewModel : BaseViewModel<long>
  {

    [FormOneToManyAssociationAttribute(AssociationType = typeof(CountryViewModel))]
    public long CountryId { get; set; }
    public string Name { get; set; }
    public GeoPointViewModel Location { get; set; }

    public override string OptionText => Name;
  }
}
