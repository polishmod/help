using AgileObjects.AgileMapper;
using CovidHelp.Helpers;
using CovidHelp.Models.Entities;
using CovidHelp.Models.ViewModels;
using NetTopologySuite.Geometries;

namespace CovidHelp.Configuration
{
  public static class ModelMappingConfig
  {
    public static void ConfigureMappings()
    {


      Mapper.WhenMapping
        .From<Point>()
        .To<GeoPointViewModel>()
        .MapFunc(source => GeoHelper.CreatePointViewModelFromPoint(source));

      Mapper.WhenMapping
        .From<GeoPointViewModel>()
        .To<Point>()
        .MapFunc(source => GeoHelper.CreatePointFromViewModelPoint(source));

    }
  }
}
