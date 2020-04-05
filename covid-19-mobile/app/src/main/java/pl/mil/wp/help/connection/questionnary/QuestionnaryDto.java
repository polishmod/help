package pl.mil.wp.help.connection.questionnary;

import java.util.List;

public class QuestionnaryDto {
    private long userId;
    private String date;
    private double temperature;
    private String returnedFromAbroad;
    private String hadCloseContactToDiagnosed;
    private String hadCloseContactDuringTravel;
    private String obeyToHygieneRules;
    private boolean hadYouExpriencedLackOfTasteOrSmell;
    private List<String> symptoms;

    public QuestionnaryDto() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getReturnedFromAbroad() {
        return returnedFromAbroad;
    }

    public void setReturnedFromAbroad(String returnedFromAbroad) {
        this.returnedFromAbroad = returnedFromAbroad;
    }

    public String getHadCloseContactToDiagnosed() {
        return hadCloseContactToDiagnosed;
    }

    public void setHadCloseContactToDiagnosed(String hadCloseContactToDiagnosed) {
        this.hadCloseContactToDiagnosed = hadCloseContactToDiagnosed;
    }

    public String getHadCloseContactDuringTravel() {
        return hadCloseContactDuringTravel;
    }

    public void setHadCloseContactDuringTravel(String hadCloseContactDuringTravel) {
        this.hadCloseContactDuringTravel = hadCloseContactDuringTravel;
    }

    public String getObeyToHygieneRules() {
        return obeyToHygieneRules;
    }

    public void setObeyToHygieneRules(String obeyToHygieneRules) {
        this.obeyToHygieneRules = obeyToHygieneRules;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isHadYouExpriencedLackOfTasteOrSmell() {
        return hadYouExpriencedLackOfTasteOrSmell;
    }

    public void setHadYouExpriencedLackOfTasteOrSmell(boolean hadYouExpriencedLackOfTasteOrSmell) {
        this.hadYouExpriencedLackOfTasteOrSmell = hadYouExpriencedLackOfTasteOrSmell;
    }
}
