package pl.mil.wp.help.connection.authentication;

import pl.mil.wp.help.connection.authentication.data.EmptyRequest;
import pl.mil.wp.help.connection.authentication.data.LoginAuthData;
import pl.mil.wp.help.connection.authentication.data.RegisterAuthData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthService {
    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @POST("/api/ApiAuthentication/Register")
    Call<AuthResponse> register(@Body RegisterAuthData registerAuthData);

    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @POST("/api/ApiAuthentication/Authenticate")
    Call<AuthResponse> login(@Body LoginAuthData loginAuthData);

    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json; charset=utf-8"
    })
    @POST("/api/ApiAuthentication/RegisterAnonymous")
    Call<RegisterAnonymousAuthResponse> registerAnonymously(@Body EmptyRequest emptyData);
}
