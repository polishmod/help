package pl.mil.wp.help.connection.questionnary;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface QuestionnaryService {

    @Headers({
            "Access-Control-Allow-Origin: *",
            "Content-Type: application/json-patch+json"
    })
    @POST("/api/ApiSurvey")
    Call<QuestionnaryResponse> sendQuestionnaryData(@Header("Authorization") String token, @Body QuestionnaryDto registerAuthData);

}
