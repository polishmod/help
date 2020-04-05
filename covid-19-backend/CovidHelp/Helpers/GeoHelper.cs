using CovidHelp.Models.ViewModels;
using NetTopologySuite.Geometries;
using NetTopologySuite.Utilities;
using System.Collections.Generic;

namespace CovidHelp.Helpers
{
  public static class GeoHelper
  {


    public static Point CreatePointFromLatLon(double lat, double lon)
    {
      return new Point(lon, lat) { SRID = 4326 };
    }
    public static GeoPointViewModel CreatePointViewModelFromPoint(Point point)
    {
      if (point == null)
      {
        return null;
      }
      return new GeoPointViewModel()
      {
        Lat = point.Y,
        Lon = point.X
      };
    }
    public static Point CreatePointFromViewModelPoint(GeoPointViewModel point)
    {
      if (point == null)
      {
        return null;
      }
      return CreatePointFromLatLon(point.Lat, point.Lon);
    }
  }
}
