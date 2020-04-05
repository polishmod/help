package pl.mil.wp.help.connection.authentication;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class RegisterAnonymousAuthResponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("detail")
    String detail;
    @SerializedName("uiConfig")
    UiConfig uiConfig;
    @SerializedName("content")
    RegisterAnonymousAuthResponseContent content;
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

    public RegisterAnonymousAuthResponseContent getContent() {
        return content;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public static class RegisterAnonymousAuthResponseContent {
        @SerializedName("email")
        String email;
        @SerializedName("password")
        String password;

        @SerializedName("uid")
        String uid;

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getUid() {
            return uid;
        }
    }
}

