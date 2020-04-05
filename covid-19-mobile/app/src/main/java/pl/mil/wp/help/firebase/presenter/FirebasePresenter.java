package pl.mil.wp.help.firebase.presenter;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Sebastian Paciorek
 */
public class FirebasePresenter {

    private static FirebasePresenter INSTANCE;

    private FirebasePresenter() {
    }

    public static FirebasePresenter getInstance() {
        if (INSTANCE == null) {
            synchronized (FirebasePresenter.class){
                if (INSTANCE == null) {
                    INSTANCE = new FirebasePresenter();
                }
            }
        }
        return INSTANCE;
    }

    public String getToken() {
        return FirebaseInstanceId.getInstance().getToken();
    }

}
