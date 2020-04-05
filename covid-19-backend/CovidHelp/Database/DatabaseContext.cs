using CovidHelp.Database.EntityTypeConfiguration;
using CovidHelp.Models.Entities;
using Innofactor.EfCoreJsonValueConverter;
using Microsoft.EntityFrameworkCore;
using NetCoreCommons.Database.Services;
namespace CovidHelp.Database
{
  public class DatabaseContext : AbstractDbContext
  {
    public DatabaseContext(DbContextOptions options) : base(options)
    {
    }

    public DbSet<AppUser> Users { get; set; }
    public DbSet<Survey> Surveys { get; set; }

    public DbSet<UserLocation> UserLocations { get; set; }
    public DbSet<InfectedStatistics> InfectedStatistics { get; set; }
    public DbSet<Country> Countries { get; set; }
    public DbSet<City> Cities { get; set; }
    public DbSet<FirebaseNotification> FirebaseNotifications { get; set; }
    protected override void InitModelMappings(ModelBuilder modelBuilder)
    {
      base.InitModelMappings(modelBuilder);
      modelBuilder
         .ApplyConfiguration(new AppUserEntityTypeConfiguration());

    }
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
      base.OnModelCreating(modelBuilder);
      modelBuilder.AddJsonFields();
    }


    public async override void Seed()
    {
      base.Seed();
      await this.SeedDefaultAppUsers();
      await this.SeedCountries();
      await this.SeedCities(false);
      await this.SeedRandomUsers(true);
      await this.SeedRandomUserLocation();
    }



  }
}
