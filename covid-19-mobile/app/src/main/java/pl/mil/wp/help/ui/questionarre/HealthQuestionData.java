package pl.mil.wp.help.ui.questionarre;

import java.util.Arrays;
import java.util.List;

public class HealthQuestionData extends QuestionData {
    private final static List<String> healthTicks = Arrays.asList(
            "No", "Sometimes", "Mostly", "Almost ever", "Ever"
    );

    HealthQuestionData(String question) {
        super(question, healthTicks);
    }

    public HealthQuestionData(String question, int resourceId) {
        super(question, resourceId, healthTicks);
    }

}
