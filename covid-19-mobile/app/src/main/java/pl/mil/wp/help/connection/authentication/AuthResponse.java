package pl.mil.wp.help.connection.authentication;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AuthResponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("detail")
    String detail;
    @SerializedName("uiConfig")
    UiConfig uiConfig;
    @SerializedName("content")
    String content;
    @SerializedName("errors")
    List<Error> errors;

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

    public String getContent() {
        return content;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
