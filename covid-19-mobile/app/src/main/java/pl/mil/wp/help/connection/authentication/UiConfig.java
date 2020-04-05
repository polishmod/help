package pl.mil.wp.help.connection.authentication;

import com.google.gson.annotations.SerializedName;

public class UiConfig {
    @SerializedName("timeout")
    private float timeout;
    @SerializedName("type")
    private String type;

    // Getter Methods

    public float getTimeout() {
        return timeout;
    }

    public String getType() {
        return type;
    }

    // Setter Methods

    public void setTimeout(float timeout) {
        this.timeout = timeout;
    }

    public void setType(String type) {
        this.type = type;
    }
}