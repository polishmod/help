using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using CovidHelp.Models.Entities;

namespace CovidHelp.Database.EntityTypeConfiguration
{
  public sealed class AppUserEntityTypeConfiguration : IEntityTypeConfiguration<AppUser>
  {
    public AppUserEntityTypeConfiguration()
    {
    }

    public void Configure(EntityTypeBuilder<AppUser> builder)
    {
      builder.HasIndex(x => x.Email).IsUnique();
    
      builder.Property(x => x.Password).IsRequired().HasMaxLength(500);
      builder.Property(x => x.Status).IsRequired();

      builder
       .HasMany(c => c.Patients)
       .WithOne(e => e.Doctor);

    }
  }
}
