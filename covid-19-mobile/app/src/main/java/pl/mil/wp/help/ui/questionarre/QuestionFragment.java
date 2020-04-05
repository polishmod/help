package pl.mil.wp.help.ui.questionarre;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mil.wp.help.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class QuestionFragment extends QuestionnareBaseFragment {
    private final static String QUESTION_TICK_LIST_ACTION = "question_tick_list";
    private final static String QUESTION_TEXT_ACTION = "question_text";
    private final static String QUESTION_IMAGE_ACTION = "question_image";
    private QuestionnareFragmentViewModel questionnareViewModel;
    private QuestionFragmentViewModel viewModel;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    private List<String> progressTicks;

    private QuestionFragment(int id) {
        super(id);
    }

    @Override
    public void save() {
        if (questionnareViewModel != null) {
            if (seekBar != null)
                questionnareViewModel.saveToTemporalStorage(questionId, seekBar.getProgress());
        }
    }

    static QuestionFragment newInstance(int questionNumber, QuestionData questionData) {
        QuestionFragment questionFragment = new QuestionFragment(questionNumber);
        Bundle bundle = new Bundle();
        bundle.putString(QUESTION_TEXT_ACTION, questionData.question);
        bundle.putInt(QUESTION_IMAGE_ACTION, questionData.resourceId);
        bundle.putStringArrayList(QUESTION_TICK_LIST_ACTION, new ArrayList<>(questionData.progressTicks));
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        ButterKnife.bind(this, view);
        questionnareViewModel = new ViewModelProvider(requireActivity()).get(QuestionnareFragmentViewModel.class);
        viewModel = new ViewModelProvider(this).get(QuestionFragmentViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fillViewWithDataProvidedDuringInitialization(view);
        seekBar.setMax(progressTicks.size() - 1);
        seekBar.setOnSeekBarChangeListener((OnProgressChanged) (seekBar, progress, fromUser) -> viewModel.updateProgress(progress));
        viewModel.getProgress().observe(getViewLifecycleOwner(), progress -> tvProgress.setText(progressTicks.get(progress)));
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.i(TAG, "setUserVisibleHint: yes");
        } else {
            Log.i(TAG, "setUserVisibleHint: not");
        }
    }

    private void fillViewWithDataProvidedDuringInitialization(View view) {
        String questionText = requireArguments().getString(QUESTION_TEXT_ACTION);
        int resourceId = requireArguments().getInt(QUESTION_IMAGE_ACTION);
        progressTicks = requireArguments().getStringArrayList(QUESTION_TICK_LIST_ACTION);
        TextView textView = view.findViewById(R.id.questionText);
        textView.setText(questionText);
        ImageView imageView = view.findViewById(R.id.iv_question);
        Glide.with(this).load(resourceId).fitCenter().into(imageView);
    }
}
