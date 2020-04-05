package pl.mil.wp.help.connection.apiusers;

import pl.mil.wp.help.API.models.AppUserViewModelApiResponse;
import pl.mil.wp.help.API.models.BooleanApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Sebastian Paciorek
 */
public interface ApiUsersService {

    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @GET("/api/ApiUsers/GetMyAccount")
    Call<AppUserViewModelApiResponse> getMyAccount(@Header("Authorization") String token);

    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @POST("/api/ApiUsers/AuthorizeDoctor")
    Call<BooleanApiResponse> authorizeDoctor(@Header("Authorization") String token, @Query("doctorId") int doctorID);
}
