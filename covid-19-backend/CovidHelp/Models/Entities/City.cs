using NetCoreCommons.Database.Models;
using NetTopologySuite.Geometries;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidHelp.Models.Entities
{
  public class City : BaseEntity<long>
  {
    public Country Country { get; set; }
    public long CountryId { get; set; }
    public string Name { get; set; }
    public Point Location { get; set; }
  }
}
