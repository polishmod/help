using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidHelp.Models.Entities
{
  public enum HygeneStatusEnum
  {
    No, ALittle, AtLeastOne, MoreThanOne, SevereSymptoms
  }
  public enum HealthStatusEnum
  {
    No, Sometimes, Mostly, AlmostEver, Ever
  }
  public enum PeriodStatusEnum
  {
    No, OneThreeDaysAgo, FourSixDaysAgo, SevenTenDaysAgo, TenFourteenDaysAgo
  }
}
