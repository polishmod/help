package pl.mil.wp.help.connection.questionnary;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.mil.wp.help.connection.authentication.AuthError;
import pl.mil.wp.help.connection.authentication.UiConfig;

public class QuestionnaryResponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("detail")
    String detail;
    @SerializedName("uiConfig")
    UiConfig uiConfig;
    @SerializedName("errors")
    List<AuthError> errors;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public UiConfig getUiConfig() {
        return uiConfig;
    }

    public List<AuthError> getErrors() {
        return errors;
    }
}
