package pl.mil.wp.help.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.R;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;

    @BindView(R.id.uid_textView)
    TextView uidTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, root);
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Pair<String, Integer>> titles = Arrays.asList(
                new Pair<>("Your daily guides", R.drawable.guides),
                new Pair<>("Clean your hands", R.drawable.hand_wash),
                new Pair<>("New cases of infection", R.drawable.queue),
                new Pair<>("Is Vitamine C important?", R.drawable.oranges)
        );
        ArticlesAdapter articlesAdapter = new ArticlesAdapter(titles);
        rvArticles.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rvArticles.setAdapter(articlesAdapter);

        uidTextView.setText(SharedPreferencesUtil.getUID(getContext()));

    }

    @OnClick(R.id.cv_cough_test)
    void goToCoughRecordingFragment() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_navigation_dashboard_to_coughFragment);
    }

    @OnClick(R.id.cv_questionnare)
    void goToQuestionnare() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_navigation_dashboard_to_questionnareFragment);
    }

    @OnClick(R.id.cv_analytics)
    void goToAnalytics() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_navigation_dashboard_to_analyticsFragment);
    }

    @OnClick(R.id.cv_temperature_log)
    void goToTemperature(){
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_navigation_dashboard_to_temperatureFragment);
    }
}
