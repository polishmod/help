package pl.mil.wp.help.ui.questionarre;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.mil.wp.help.R;
import pl.mil.wp.help.ui.coughrecording.CoughRecordingFragment;

class QuestionnareAdapter extends FragmentStateAdapter {
    private List<QuestionnareBaseFragment> fragments;

    QuestionnareAdapter(@NonNull Fragment fragment, List<QuestionnareBaseFragment> fragments) {
        super(fragment);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    QuestionnareBaseFragment getItem(int position){
        return fragments.get(position);
    }

}
