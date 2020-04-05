using NetCoreCommons.Database.Attributes;
using NetCoreCommons.Security.Models.Auth;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CovidHelp.Models.Entities
{
  [Table("Users")]
  public class AppUser : BaseUser
  {
    [StoreAsStringAttribute]
    public ICollection<string> Roles { get; set; }
    [DataType(DataType.Date)]
    public DateTime DateOfBirth { get; set; }

    public Sex? Sex { get; set; }

    public Country Country { get; set; }
    public long? CountryId { get; set; }
    public City City { get; set; }
    public long? CityId { get; set; }
    public UserHealthStatus? UserHealthStatus { get; internal set; }

    public long? DoctorId { get; set; }
    public AppUser Doctor { get; set; }
    public virtual ICollection<AppUser> Patients { get; set; }

    public string UserImage { get; set; }
    public bool IsAnonymous { get; set; }

  }
}
