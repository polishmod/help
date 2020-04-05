package pl.mil.wp.help.ui.coughrecording;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.MainActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.ui.Utils;

public class CoughRecordingFragment extends Fragment {
    private final int MAX_RECORDING_S = 10;
    private final int WINDOW_LENGTH = 480;
    private CoughRecordingViewModel coughRecordingViewModel;
    private MediaRecorder recorder = new MediaRecorder();
    private LineDataSet set;
    @BindView(R.id.line_chart_temperature)
    LineChart chart;
    @BindView(R.id.record_button)
    ImageButton recordButton;
    @BindView(R.id.tv_recording_text)
    TextView recordingText;
    private int processedSamples = 0;
    @BindView(R.id.btn_finish)
    MaterialButton finishButton;
    @BindView(R.id.processing_bar)
    View processing;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        coughRecordingViewModel = new ViewModelProvider(this).get(CoughRecordingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cough_record, container, false);
        ButterKnife.bind(this, root);
        coughRecordingViewModel.getButtonIcon().observe(getViewLifecycleOwner(), val -> {
            recordButton.setImageResource(val);
        });
        coughRecordingViewModel.getNextButtonEnabled().observe(getViewLifecycleOwner(), val -> {
            disableFinishButton(val);
        });
        coughRecordingViewModel.getChartVisibility().observe(getViewLifecycleOwner(), val -> {
            chart.setVisibility(val);
        });
        coughRecordingViewModel.getFabVisibility().observe(getViewLifecycleOwner(), val -> {
            recordButton.setVisibility(val);
        });
        coughRecordingViewModel.getProcessingVisibility().observe(getViewLifecycleOwner(), val -> {
            processing.setVisibility(val);
        });
        coughRecordingViewModel.getState().observe(getViewLifecycleOwner(), val -> {
            switch (val) {
                case CoughRecordingViewModel.RECORDER_IDLE:
                    recordingText.setVisibility(View.VISIBLE);
                    recordingText.setText(getResources().getString(R.string.fragment_cough_recording_start_recording));
                    break;
                case CoughRecordingViewModel.RECORDER_RECORDING:
                    recordingText.setVisibility(View.GONE);
                    break;
                case CoughRecordingViewModel.RECORDER_PROCESSING:
                    recordingText.setVisibility(View.VISIBLE);
                    recordingText.setText(getResources().getString(R.string.fragment_cough_analyzing));
                    break;
                case CoughRecordingViewModel.RECORDER_RECORDED:
                    recordingText.setVisibility(View.VISIBLE);
                    recordingText.setText(getResources().getString(R.string.fragment_cough_again_title));
                    break;
            }
        });

        setupChart();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.iv_question_image);
        Glide.with(this).load(R.drawable.question6).fitCenter().into(imageView);
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

    public void disableFinishButton(boolean shouldEnable) {
        int backgroundTint = shouldEnable ? R.color.colorPrimary : R.color.grey_D;
        finishButton.setEnabled(shouldEnable);
        finishButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), backgroundTint)));
    }

    @OnClick(R.id.btn_finish)
    void finish() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).popBackStack();
    }

    void setupChart() {
        // disable everything!
        chart.getDescription().setEnabled(false);
        chart.setTouchEnabled(false);
        chart.setDragEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setPinchZoom(false);


        chart.setScaleEnabled(true);

        chart.setBackgroundColor(Color.TRANSPARENT);

        LineData data = new LineData();
        // add empty data
        chart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = chart.getLegend();
        l.setEnabled(false);

        XAxis xl = chart.getXAxis();
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(false);
        xl.setEnabled(false);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMaximum(33000);
        leftAxis.setAxisMinimum(-33000);
        leftAxis.setEnabled(false);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

    }

    private void addEntry() {

        LineData data = chart.getData();

        if (data != null) {

            ILineDataSet set = data.getDataSetByIndex(0);
            if (set == null) {
                set = createSet();
                data.addDataSet(set);
                for (int i = 0; i < WINDOW_LENGTH; i++) {
                    data.addEntry(new Entry(i, 0), 0);
                }
            }
            if (set.getEntryCount() > WINDOW_LENGTH) {
                set.removeFirst();
                set.removeFirst();
            }
            try {
                float amplitude = recorder.getMaxAmplitude();
                data.addEntry(new Entry(WINDOW_LENGTH + processedSamples, amplitude), 0);
                data.addEntry(new Entry(WINDOW_LENGTH + processedSamples + 1, -amplitude), 0);
                processedSamples += 2;
                data.notifyDataChanged();

                chart.notifyDataSetChanged();

                chart.setVisibleXRangeMaximum(WINDOW_LENGTH);

                chart.moveViewToX(WINDOW_LENGTH + processedSamples);
            } catch (IllegalStateException e) {
                Log.w("CoughRecordingFragment", e);
            }

        }
    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setDrawCircles(false);
        set.setDrawValues(false);
        return set;
    }

    private Thread thread;
    private Handler handler = new Handler();

    private void feedSoundData() {

        if (thread != null)
            thread.interrupt();

        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                addEntry();
            }
        };

        thread = new Thread(() -> {
            while (true) {
                Activity activity = getActivity();
                if (activity == null) {
                    break;
                }
                activity.runOnUiThread(runnable);
                try {
                    Thread.sleep(12);
                } catch (InterruptedException ignore) {
                }
            }
        });

        thread.start();
    }

    Runnable recordingTimer = () -> stopRecording();
    Runnable processingTimer = () -> finishProcessing();

    @OnClick(R.id.record_button)
    void onButtonPressed() {
        Integer state = coughRecordingViewModel.getState().getValue();
        switch (state) {
            case CoughRecordingViewModel.RECORDER_IDLE:
                startRecording();
                break;
            case CoughRecordingViewModel.RECORDER_RECORDING:
                stopRecording();
                break;
            case CoughRecordingViewModel.RECORDER_RECORDED:
                restartRecording();
                break;
        }
    }

    void startRecording() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(requireContext(), requireContext().getString(R.string.record_audio_permission_required_info), Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            recorder.setAudioSource(MediaRecorder.AudioSource.UNPROCESSED);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            recorder.setOutputFile("/dev/null");
            recorder.prepare();
            recorder.start();
            feedSoundData();
            handler.postDelayed(recordingTimer, MAX_RECORDING_S * 1000);
            coughRecordingViewModel.getState().setValue(CoughRecordingViewModel.RECORDER_RECORDING);
        } catch (IllegalStateException | IOException recorderException) {
            Toast.makeText(requireContext(), requireContext().getString(R.string.record_audio_init_failure_info), Toast.LENGTH_SHORT).show();
            Log.e(getClass().getSimpleName(), "Error", recorderException);
        }
    }

    void stopRecording() {
        finishRecording();
        coughRecordingViewModel.getState().setValue(CoughRecordingViewModel.RECORDER_PROCESSING);
        handler.postDelayed(processingTimer, 1000);
    }

    void finishProcessing(){
        coughRecordingViewModel.getState().setValue(CoughRecordingViewModel.RECORDER_RECORDED);
    }

    void finishRecording() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
        handler.removeCallbacks(recordingTimer);
        recorder.stop();
        recorder.reset();
    }
    void restartRecording() {
        startRecording();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            finishRecording();
            recorder.release();
        } catch (Exception ignore) {
            // safely attempt to release all resources
        }
    }

}
