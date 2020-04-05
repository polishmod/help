package pl.mil.wp.help.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.R;
import pl.mil.wp.help.ui.questionarre.OnProgressChanged;
import pl.mil.wp.help.ui.questionarre.QuestionnareBaseFragment;
import pl.mil.wp.help.ui.questionarre.QuestionnareFragmentViewModel;
import pl.mil.wp.help.ui.questionarre.QuestionnarePagesListProvider;

public class TemperatureFragment extends QuestionnareBaseFragment {
    private static final String IS_INSIDE_QUESTIONNARY_ACTION = "is_inside_questionnary";
    private static final int TICKS_PER_DEGREE = 10;
    private static final int MIN_TEMP = 34;
    private static final int MAX_TEMP = 41;
    private static final int INITIAL_VALUE = 366 - MIN_TEMP * TICKS_PER_DEGREE;

    @BindView(R.id.tv_temperature)
    TextView temperatureText;
    @BindView(R.id.sb_temperature)
    SeekBar seekBar;
    @BindView(R.id.btn_save)
    MaterialButton saveButton;
    private TemperatureViewModel viewModel;
    private QuestionnareFragmentViewModel questionnareViewModel;
    private boolean isInsideQuestionnary;

    public TemperatureFragment() {
        super(QuestionnarePagesListProvider.TEMPERATURE_FRAGMENT_ID);
    }

    public static TemperatureFragment newQuestionnaryInstance() {
        TemperatureFragment temperatureFragment = new TemperatureFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_INSIDE_QUESTIONNARY_ACTION, true);
        temperatureFragment.setArguments(bundle);
        return temperatureFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);
        ButterKnife.bind(this, view);
        viewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);
        if (getArguments() != null)
            isInsideQuestionnary = requireArguments().getBoolean(IS_INSIDE_QUESTIONNARY_ACTION);
        questionnareViewModel = new ViewModelProvider(requireActivity()).get(QuestionnareFragmentViewModel.class);
        seekBar.setMax((MAX_TEMP - MIN_TEMP) * TICKS_PER_DEGREE);
        seekBar.setOnSeekBarChangeListener((OnProgressChanged) (seekBar, progress, fromUser) -> updateProgress());
        seekBar.setProgress(INITIAL_VALUE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saveButton.setVisibility(isInsideQuestionnary ? View.GONE : View.VISIBLE);
    }

    @OnClick(R.id.btn_save)
    void saveTemperature() {
        Toast.makeText(requireContext(), requireContext().getString(R.string.temperature_save_results_success_info), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void save() {
        if (questionnareViewModel != null) {
            if (seekBar != null)
                questionnareViewModel.saveToTemporalStorage(questionId, (int) ((getCurrentTemp() * 10)));

        }
    }

    private float getCurrentTemp() {
        return MIN_TEMP + seekBar.getProgress() / (float) TICKS_PER_DEGREE;
    }

    private void updateProgress() {
        temperatureText.setText(String.format("%.1f°C", getCurrentTemp()));
    }

}
