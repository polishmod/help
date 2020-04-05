package pl.mil.wp.help.ui.questionarre;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.ekn.gruzer.gaugelibrary.Range;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.button.MaterialButton;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.MainActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.ui.Utils;
import pl.mil.wp.help.ui.questionarre.custom_views.ArcGaugeWithoutValue;

public class QuestionnarySumaryFragment extends Fragment {

    QuestionnareFragmentViewModel questionnareViewModel;

    @BindView(R.id.iv_question)
    ImageView questionImage;
    @BindView(R.id.summary_gauge)
    ArcGaugeWithoutValue arcGauge;
    @BindView(R.id.tv_questionnary_summary_gauge)
    TextView gaugeText;
    @BindView(R.id.tv_diagnosing)
    TextView diagnosingText;
    @BindView(R.id.loading_indicator)
    SpinKitView loadingIndicator;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnary_summary, container, false);
        ButterKnife.bind(this, view);
        Glide.with(this).load(R.drawable.mobile_doctor).fitCenter().into(questionImage);
        questionnareViewModel = new ViewModelProvider(requireActivity()).get(QuestionnareFragmentViewModel.class);
        initGauge();
        setValue(22);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            gaugeText.setVisibility(View.VISIBLE);
            arcGauge.setVisibility(View.VISIBLE);
            diagnosingText.setVisibility(View.GONE);
            loadingIndicator.setVisibility(View.GONE);
        }, 3000);
    }

    private void setValue(double value) {

        int propabilityPercent = (int) (questionnareViewModel.propability * 100);
        String stringValue = String.format(Locale.getDefault(), "%d", propabilityPercent);
        gaugeText.setText(String.format("Risk level:\n%s%%", stringValue));
        arcGauge.setValue(propabilityPercent);
    }

    private void initGauge() {
        Range range = new Range();
        range.setColor(Color.parseColor("#66bb6a"));
        range.setFrom(0);
        range.setTo(33);

        Range range2 = new Range();
        range2.setColor(Color.parseColor("#ffee58"));
        range2.setFrom(33);
        range2.setTo(66);

        Range range3 = new Range();
        range3.setColor(Color.parseColor("#ef5350"));
        range3.setFrom(66);
        range3.setTo(100);

        arcGauge.addRange(range);
        arcGauge.addRange(range2);
        arcGauge.addRange(range3);
        arcGauge.setUseRangeBGColor(true);

        arcGauge.setMinValue(0);
        arcGauge.setMaxValue(100);
    }

    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity) requireActivity()).getNavigationView().setVisibility(View.VISIBLE);
        Utils.disableFullscreen(requireActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) requireActivity()).getNavigationView().setVisibility(View.GONE);
        Utils.enableFullscreen(requireActivity());
    }

    @OnClick(R.id.btn_finish_quesionnary_summary)
    void finish() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).popBackStack();
    }

}
