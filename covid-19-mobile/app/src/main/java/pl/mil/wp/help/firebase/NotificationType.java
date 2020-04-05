package pl.mil.wp.help.firebase;

/**
 * Created by Sebastian Paciorek
 */
public enum NotificationType {

    INFO("INFO"),
    FILL_QUESTIONNAIRE("FILL_QUESTIONNAIRE"),
    MET_INFECTED("MET_INFECTED"),
    MEASURE_TEMPERATURE("MEASURE_TEMPERATURE"),
    DATA_PERMISSION("DATA_PERMISSION");

    private String notificationType;

    NotificationType(String notificationTye) {
        this.notificationType = notificationTye;
    }

    public String getNotificationType(){
        return notificationType;
    }
}
