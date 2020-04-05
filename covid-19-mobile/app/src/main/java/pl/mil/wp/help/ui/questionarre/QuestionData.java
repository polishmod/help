package pl.mil.wp.help.ui.questionarre;

import java.util.List;

abstract class QuestionData {
    String question;
    int resourceId;
    List<String> progressTicks;

    QuestionData(String question, List<String> progressTicks) {
        this.question = question;
        this.progressTicks = progressTicks;
    }

    public QuestionData(String question, int resourceId, List<String> progressTicks) {
        this.question = question;
        this.resourceId = resourceId;
        this.progressTicks = progressTicks;
    }

    public String getQuestion() {
        return question;
    }

    public int getResourceId() {
        return resourceId;
    }

    public List<String> getProgressTicks() {
        return progressTicks;
    }
}
