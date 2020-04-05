package pl.mil.wp.help.ui.questionarre;

import java.util.Arrays;
import java.util.List;

public class HygienQuestionData extends QuestionData {

    private final static List<String> hygeneTicks = Arrays.asList(
            "No", "A little", "At least one", "More than one", "Severe symptoms"
    );

    HygienQuestionData(String question) {
        super(question, hygeneTicks);
    }

    public HygienQuestionData(String question, int resourceId) {
        super(question, resourceId, hygeneTicks);
    }
}