using NetCoreCommons.Database.Models;
using System;

namespace CovidHelp.Models.Entities
{
  public enum FirebaseNotificationTypeEnum
  {
    Info,
    Met_Infected,
    Fill_Questionnarie,
    Measure_Temperature
  }
  public class FirebaseNotification : BaseEntity<long>
  {
    public string Title { get; set; }
    public string Message { get; set; }
    public FirebaseNotificationTypeEnum Type { get; set; }
    public long FromUserId { get; set; }
    public long ToUserId { get; set; }

    public DateTime? DateSend { get; set; }
  }
}
