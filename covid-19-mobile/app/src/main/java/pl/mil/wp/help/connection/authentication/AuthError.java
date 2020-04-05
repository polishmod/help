package pl.mil.wp.help.connection.authentication;

import com.google.gson.annotations.SerializedName;

public class AuthError {
    @SerializedName("field")
    String field;
    @SerializedName("message")
    String message;
}
