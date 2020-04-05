package pl.mil.wp.help.ui.questionarre;

import android.widget.SeekBar;

public interface OnProgressChanged extends SeekBar.OnSeekBarChangeListener {

    @Override
    default void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    default void onStopTrackingTouch(SeekBar seekBar) {

    }
}
