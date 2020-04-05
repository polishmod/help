using NetCoreCommons.Database.Models;
using NetTopologySuite.Geometries;
using System;
using System.ComponentModel.DataAnnotations;

namespace CovidHelp.Models.Entities
{
  public class UserLocation : BaseEntity<long>
  {

    public Point Location { get; set; }
    public double Precision { get; set; }
    [DataType(DataType.DateTime)]
    public DateTime Date { get; set; }
    // do grupowania po czasie
    public long GroupTimestamp { get; set; }
    // do raportowania po miescie
    public long? CityId { get; set; }
    public City City { get; set; }
    // do raportowania po kraju
    // redundancja ale za to latwiej w filtrach
    public long? CountryId { get; set; }
    public Country Country { get; set; }
    public long UserId { get; set; }
    public AppUser User { get; set; }
  }
}
