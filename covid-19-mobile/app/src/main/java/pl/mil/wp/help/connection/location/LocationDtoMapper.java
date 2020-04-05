package pl.mil.wp.help.connection.location;

import pl.mil.wp.help.room.entities.location.Location;

public class LocationDtoMapper {

    public static LocationDto locationToDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setLocation(new LocationPoint(1, 1));
        locationDto.setDate("2020-04-05T04:39:00");
        locationDto.setGuid("");
        return locationDto;
    }

}
