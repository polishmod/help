package pl.mil.wp.help.ui.questionarre;

import java.util.Arrays;
import java.util.List;

public class HygieneQuestionData extends QuestionData {
    private final static List<String> healthTicks = Arrays.asList(
            "No", "Sometimes", "Mostly", "Almost ever", "Ever"
    );

    HygieneQuestionData(String question) {
        super(question, healthTicks);
    }

    public HygieneQuestionData(String question, int resourceId) {
        super(question, resourceId, healthTicks);
    }

}
