package pl.mil.wp.help.ui.questionarre;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import pl.mil.wp.help.R;

public class QuestionSymptomsFragment extends QuestionnareBaseFragment {
    private final static String TAG = QuestionSymptomsFragment.class.getSimpleName();

    private QuestionnareFragmentViewModel questionnareViewModel;
    private List<Integer> valueList = new ArrayList<>();
    ;
    @BindView(R.id.iv_question)
    ImageView questionImage;

    public QuestionSymptomsFragment(int id) {
        super(id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_symptoms, container, false);
        ButterKnife.bind(this, view);
        questionnareViewModel = new ViewModelProvider(requireActivity()).get(QuestionnareFragmentViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(this).load(R.drawable.img_symptoms).fitCenter().into(questionImage);
    }

    @Override
    public void save() {
        if (questionnareViewModel != null) {
            questionnareViewModel.saveToTemporalStorage(questionId, valueList);
        }
    }

    @OnCheckedChanged({R.id.chk_fever, R.id.chk_headache, R.id.chk_runny_nose, R.id.chk_cough, R.id.chk_sore_throat, R.id.chk_red_eyes})
    void checkBoxChanged(CompoundButton button, boolean checked) {
        if (checked) {
            valueList.add(getValueForId(button.getId()));
        } else {
            valueList.removeIf(integer -> integer == getValueForId(button.getId()));
        }
    }

    private int getValueForId(int id) {
        switch (id) {
            case R.id.chk_fever:
                return 1;
            case R.id.chk_headache:
                return 2;
            case R.id.chk_runny_nose:
                return 3;
            case R.id.chk_cough:
                return 4;
            case R.id.chk_sore_throat:
                return 5;
            case R.id.chk_red_eyes:
                return 6;
            default:
                return -1;
        }
    }

}


