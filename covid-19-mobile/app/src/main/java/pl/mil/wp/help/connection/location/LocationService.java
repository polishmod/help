package pl.mil.wp.help.connection.location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LocationService {

    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @POST("/api/ApiUserLocation")
    Call<LocationResponse> sendLocationData(@Header("Authorization") String token, @Body LocationDto location);


    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @POST("/api/ApiUserLocation/BulkCreate")
    Call<LocationResponse> sendLocationData(@Header("Authorization") String token, @Body List<LocationDto> location);
}
