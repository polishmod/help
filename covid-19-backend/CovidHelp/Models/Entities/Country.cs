using NetCoreCommons.Database.Models;
using NetTopologySuite.Geometries;

namespace CovidHelp.Models.Entities
{
  public class Country : BaseEntity<long>
  {
    public string Code { get; set; }
    public string Name { get; set; }
    public Point Location { get; set; }
  }
}
