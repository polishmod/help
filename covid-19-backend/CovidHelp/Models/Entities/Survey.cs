using NetCoreCommons.Database.Models;
using CovidHelp.Models.Entities;
using System;
using System.ComponentModel.DataAnnotations;

namespace CovidHelp.Models.Entities
{
  public class Survey : BaseEntity<long>
  {
    public long UserId { get; set; }
    public AppUser User { get; set; }
    [DataType(DataType.DateTime)]
    public DateTime Date { get; set; }

    public PeriodStatusEnum ReturnedFromAbroad { get; set; }
    public PeriodStatusEnum HadCloseContactToDiagnosed { get; set; }
    public PeriodStatusEnum HadCloseContactDuringTravel { get; set; }
    public HygeneStatusEnum ObeyToHygieneRules { get; set; }
    public HealthStatusEnum HadSymptoms { get; set; }
    public double Temperature { get; set; }
  }
}
