using NetCoreCommons.Database.Models;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CovidHelp.Models.Entities
{
  public class InfectedStatistics : BaseEntity<long>
  {
    public long CountryId { get; set; }
    public Country Country { get; set; }
    [DataType(DataType.Date)]
    [Column(TypeName = "date")]
    public DateTime Date { get; set; }
    public long Confirmed { get; set; }
    public long Deaths { get; set; }
    public long Recovered { get; set; }
  }

}
