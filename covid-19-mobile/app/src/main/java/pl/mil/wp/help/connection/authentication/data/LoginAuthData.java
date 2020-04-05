package pl.mil.wp.help.connection.authentication.data;

public class LoginAuthData {

    String email;
    String password;
    String fcmToken;
    String uid;

    public LoginAuthData() {
    }

    public LoginAuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginAuthData(String email, String password, String fcmToken) {
        this.email = email;
        this.password = password;
        this.fcmToken = fcmToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
