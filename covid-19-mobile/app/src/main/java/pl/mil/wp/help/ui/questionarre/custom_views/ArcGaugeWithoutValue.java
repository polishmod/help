package pl.mil.wp.help.ui.questionarre.custom_views;

import android.content.Context;
import android.util.AttributeSet;

import com.ekn.gruzer.gaugelibrary.ArcGauge;

public class ArcGaugeWithoutValue extends ArcGauge {

    public ArcGaugeWithoutValue(Context context) {
        super(context);
        setDrawValueText(false);
    }

    public ArcGaugeWithoutValue(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawValueText(false);
    }

    public ArcGaugeWithoutValue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDrawValueText(false);
    }

    public ArcGaugeWithoutValue(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setDrawValueText(false);
    }

}
