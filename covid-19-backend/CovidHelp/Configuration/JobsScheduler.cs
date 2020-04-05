using CovidHelp.Services.Schedules;
using Hangfire;
using NetCoreCommons;
using NetCoreCommons.DI.Services;
using NetCoreCommons.Shared.Services;
using System;

namespace CovidHelp.Configuration
{
  public static class JobsScheduler
  {
    public static void OrganizeJobs()
    {
      // TASKI
      RecurringJob.AddOrUpdate(
          CommonsConstants.SEND_EMAIL_JOB,
          () => JobsScheduler.RunService(typeof(EmailScheduleService)),
          "0 */5 * * * *");
      RecurringJob.AddOrUpdate(
        "FirebaseSender",
         () => JobsScheduler.RunService(typeof(FirebaseNotificationsScheduler)),
         "0 */5 * * * *");
      RecurringJob.AddOrUpdate(
               "StatsImport",
                 () => JobsScheduler.RunService(typeof(StatisticsImporter)),
                 "0 0 */5 * * *");
    }

    public static void RunService(Type serviceType)
    {
      var service = DependencyInjector.GetService<AbstractScheduleJob>(serviceType);
      if (service != null)
      {
        service.InvokeJob();
      }
    }
  }
}
