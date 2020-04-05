package pl.mil.wp.help.ui.questionarre;

import androidx.fragment.app.Fragment;

public abstract class QuestionnareBaseFragment extends Fragment {
    public int questionId = -1;

    public QuestionnareBaseFragment(int id) {
        this.questionId = id;
    }
    public abstract void save();
}
