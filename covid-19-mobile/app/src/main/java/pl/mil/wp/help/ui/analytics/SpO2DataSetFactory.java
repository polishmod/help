package pl.mil.wp.help.ui.analytics;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class SpO2DataSetFactory implements LineDataSetFactory<Integer> {
    private final static String title = "Spo2";

    @Override
    public LineDataSet createLineDataSet(List<Integer> inputValues) {
        LineDataSet dataSet = new LineDataSet(getTemperatureEntries(inputValues), title);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setCubicIntensity(0.02f);
        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);
        return dataSet;
    }


    private List<Entry> getTemperatureEntries(List<Integer> inputValues) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < inputValues.size(); i++) {
            entries.add(new Entry(i, inputValues.get(i)));
        }
        return entries;
    }

}
