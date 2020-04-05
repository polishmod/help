package pl.mil.wp.help.ui.analytics;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class TemperatureRateDataSetFactory implements LineDataSetFactory<Float> {
    private final static String title = "Temperature";

    @Override
    public LineDataSet createLineDataSet(List<Float> inputValues) {
        LineDataSet dataSet = new LineDataSet(getTemperatureEntries(inputValues), title);
        dataSet.setMode(LineDataSet.Mode.STEPPED);
        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);
        return dataSet;
    }


    private List<Entry> getTemperatureEntries(List<Float> inputValues) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < inputValues.size(); i++) {
            entries.add(new Entry(i, inputValues.get(i)));
        }
        return entries;
    }
}
