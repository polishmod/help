package pl.mil.wp.help.ui.questionarre;

import java.util.Arrays;
import java.util.List;

public class PeriodQuestionData extends QuestionData {
    private final static List<String> periodTicks = Arrays.asList(
            "No", "1-3 days ago", "4-6 days ago", "7-10 days ago", "10-14 days ago"
    );


    PeriodQuestionData(String question) {
        super(question, periodTicks);
    }

    public PeriodQuestionData(String question, int resourceId) {
        super(question, resourceId, periodTicks);
    }
}
