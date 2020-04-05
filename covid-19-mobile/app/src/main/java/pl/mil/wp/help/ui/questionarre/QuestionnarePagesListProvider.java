package pl.mil.wp.help.ui.questionarre;

import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

import pl.mil.wp.help.R;
import pl.mil.wp.help.ui.TemperatureFragment;

public class QuestionnarePagesListProvider {
    public static int ABROAD_FRAGMENT_ID = 1;
    public static int CLOSE_CONTACT_WITH_DIAGNOSED_FRAGMENT_ID = 2;
    public static int CLOSE_CONTACT_WITH_ABROAD_FRAGMENT_ID = 3;
    public static int OBEYING_HYGIENE_FRAGMENT_ID = 4;
    public static int SYMPTOMS_FRAGMENT_ID = 5;
    public static int TEMPERATURE_FRAGMENT_ID = 6;
    public static int LACK_OF_SENSE = 7;
    public static int PROVIDER_ITEMS_SIZE = 8;

    List<QuestionnareBaseFragment> getQuestionnaryPages(Context context) {
        return Arrays.asList(
                QuestionFragment.newInstance(ABROAD_FRAGMENT_ID, new PeriodQuestionData(context.getResources().getString(R.string.question_fragment_abroad_text), R.drawable.img_returned_from_abroad)),
                QuestionFragment.newInstance(CLOSE_CONTACT_WITH_DIAGNOSED_FRAGMENT_ID, new PeriodQuestionData(context.getResources().getString(R.string.question_fragment_close_contact_with_diagnosed), R.drawable.img_had_close_contact_with_diagnosed)),
                QuestionFragment.newInstance(CLOSE_CONTACT_WITH_ABROAD_FRAGMENT_ID, new PeriodQuestionData(context.getResources().getString(R.string.question_fragment_close_contact_with_travelers), R.drawable.img_contact_with_abdroad_guy)),
                QuestionFragment.newInstance(OBEYING_HYGIENE_FRAGMENT_ID, new HygieneQuestionData(context.getResources().getString(R.string.question_fragment_hygiene), R.drawable.img_hygiene)),
                new QuestionFragmentLackOfTaste(LACK_OF_SENSE),
                new QuestionSymptomsFragment(SYMPTOMS_FRAGMENT_ID),
                TemperatureFragment.newQuestionnaryInstance());

    }

}
