using NetCoreCommons.Shared.Helpers;
using NetCoreCommons.Shared.Models;
using System;

namespace CovidHelp.Models.ViewModels
{
  public class InfectedStatisticsViewModel : BaseViewModel<long>
  {
    public long CountryId { get; set; }
    // mapped from mapper
    public string CountryName { get; set; }
    public GeoPointViewModel CountryLocation { get; set; }
    public DateTime Date { get; set; }
    public long Confirmed { get; set; }
    public long Deaths { get; set; }
    public long Recovered { get; set; }
    public override string OptionText => $"{CountryName} {FormattingHelper.GetFormattedDate(Date)}";
  }
}
