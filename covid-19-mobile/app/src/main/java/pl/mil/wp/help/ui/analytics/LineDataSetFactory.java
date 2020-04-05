package pl.mil.wp.help.ui.analytics;

import com.github.mikephil.charting.data.LineDataSet;

import java.util.List;

public interface LineDataSetFactory<T> {
    LineDataSet createLineDataSet(List<T> inputValues);
}
