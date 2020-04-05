package pl.mil.wp.help.ui.analytics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mil.wp.help.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnalyticsFragment extends Fragment {
    @BindView(R.id.line_chart_temperature)
    LineChart temperatureChart;
    @BindView(R.id.line_chart_spo2)
    LineChart spo2Chart;

    public AnalyticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_analytics, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initChart(temperatureChart);
        setMinMaxForChar(temperatureChart, 34, 41);
        initChart(spo2Chart);
        setMinMaxForChar(spo2Chart, 80, 100);
        fillTemeperatureChartWithData();
        fillSpo2ChartWithData();
    }

    private void fillTemeperatureChartWithData() {
        LineDataSet temperatureDataSet = new TemperatureRateDataSetFactory().createLineDataSet(TemperatureValuesMockProvider.temperatureValues);
        temperatureDataSet.setColor(ContextCompat.getColor(requireContext(), android.R.color.transparent));
        temperatureDataSet.setDrawFilled(true);
        temperatureDataSet.setFillDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.fade_temperature));

        temperatureChart.setData(new LineData(temperatureDataSet));
        temperatureChart.invalidate();
    }

    private void fillSpo2ChartWithData() {
        LineDataSet temperatureDataSet = new SpO2DataSetFactory().createLineDataSet(Spo2ValuesMockProvider.values);
        temperatureDataSet.setColor(ContextCompat.getColor(requireContext(), android.R.color.transparent));
        temperatureDataSet.setDrawFilled(true);
        temperatureDataSet.setFillDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.fade_spo));

        spo2Chart.setData(new LineData(temperatureDataSet));
        spo2Chart.invalidate();
    }

    private void setMinMaxForChar(LineChart chart, int min, int max){
        chart.getAxisLeft().setAxisMinimum(min);
        chart.getAxisLeft().setAxisMaximum(max);
    }


    private void initChart(LineChart chart) {
        chart.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white));
        chart.getDescription().setEnabled(false);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.setPinchZoom(true);
        chart.getAxisLeft().setDrawLabels(true);
        chart.getAxisLeft().setDrawAxisLine(true);
        chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setEnabled(true);

        chart.setTouchEnabled(false);
        chart.getXAxis().setAvoidFirstLastClipping(true);
        chart.getXAxis().setLabelCount(6, true);

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setValueFormatter(new XAxisValueFormatter());

        chart.getLegend().setEnabled(false);
    }

    class XAxisValueFormatter extends com.github.mikephil.charting.formatter.ValueFormatter {
        @Override
        public String getFormattedValue(float value) {
            return (((int) value) % 25) + ":00";
        }
    }

}
