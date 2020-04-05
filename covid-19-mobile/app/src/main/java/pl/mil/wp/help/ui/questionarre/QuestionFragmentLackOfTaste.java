package pl.mil.wp.help.ui.questionarre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mil.wp.help.R;

public class QuestionFragmentLackOfTaste extends QuestionnareBaseFragment {
    private QuestionnareFragmentViewModel questionnareViewModel;
    @BindView(R.id.radio_btn_yes)
    RadioButton radioButtonYes;

    public QuestionFragmentLackOfTaste(int id) {
        super(id);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_lack_of_taste, container, false);
        ButterKnife.bind(this, view);
        questionnareViewModel = new ViewModelProvider(requireActivity()).get(QuestionnareFragmentViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.iv_question);
        Glide.with(this).load(R.drawable.scents).fitCenter().into(imageView);
    }

    @Override
    public void save() {
        if (questionnareViewModel != null) {
            questionnareViewModel.saveToTemporalStorage(questionId, radioButtonYes.isChecked() ? 1 : 0);
        }
    }
}
