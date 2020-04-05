using Microsoft.AspNetCore.Http;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.DependencyInjection.Extensions;
using NetCoreCommons.Configuration;
using NetCoreCommons.Configuration.Models;
using NetCoreCommons.DI.Services;
using NetCoreCommons.Security.Helpers;
using NetCoreCommons.Web.Filters;
using CovidHelp.Configuration;
using CovidHelp.Database;
using System;
using NetCoreCommons.Shared.Services;

namespace CovidHelp
{
  public class Startup : BaseStartup
  {
    public Startup(IConfiguration configuration) : base(configuration)
    {
    }


    protected override void InitDependecyInjection(IConfiguration configuration, IServiceCollection services, AppConfig appConfig)
    {
      // repositories, services injected via annotations
      //services.AddDependencyInjectionCustom<DatabaseContext>(configuration, appConfig);
      DependencyInjectorConfigurator.RegisterServices(services);
      services.AddDbContextPool<DatabaseContext>(options => options
        .UseLoggerFactory(ApplicationLogger.GetLoggedFactory())
        .UseSqlServer(configuration.GetConnectionString(appConfig.DbConnectionName), x => x.UseNetTopologySuite())
      );

      DependencyInjector.GetService<DatabaseContext>().Seed();


      services.TryAddSingleton<IHttpContextAccessor, HttpContextAccessor>();
      // Auth
      services.AddScoped<ICriptography, Criptography>();
      // Filters
      services.AddScoped<ExceptionFilter>();


    }
    public override void OnApplicationStarted()
    {
      base.OnApplicationStarted();
      JobsScheduler.OrganizeJobs();
      ModelMappingConfig.ConfigureMappings();

      DependencyInjector.GetService<DatabaseContext>().Database.Migrate();
    }

    protected override AppConfig GetConfig()
    {
      return new AppConfig()
      {
        AppName = "Generic app",
        AuthConfig = new AuthConfig() { },
        HangfireConfig = new HangfireConfig(),
        SwaggerConfig = new SwaggerConfig(),
        SpaConfig = new SpaConfig()
        {
          RootPath = "./angular/dist/front",
          SpaOptions = new Microsoft.AspNetCore.SpaServices.SpaOptions()
          {
            SourcePath = "./angular"
          }
        },
        LicenceKey = "MkCzLQ5pJr1vLB8="
      };
    }
  }
}
