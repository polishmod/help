package pl.mil.wp.help.ui.questionarre;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.MainActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.questionnary.UploadManager;
import pl.mil.wp.help.ui.Utils;

public class QuestionnareFragment extends Fragment {
    private QuestionnareFragmentViewModel viewModel;
    @BindView(R.id.btn_next)
    MaterialButton nextButton;
    @BindView(R.id.btn_finish)
    MaterialButton finishButton;
    @BindView(R.id.questionarre_pager)
    ViewPager2 questionarrePager;
    private boolean shouldDisableFullscreenAfterFinish = true;
    private int pagerSize = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnare, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(QuestionnareFragmentViewModel.class);
        viewModel.setCurrentPageNumber(0);
        viewModel.clearQuestionnaryData();
        viewModel.getNextButtonVisibility().observe(getViewLifecycleOwner(), visibility -> {
            nextButton.setVisibility(visibility);
        });
        viewModel.getSummaryButtonVisibility().observe(getViewLifecycleOwner(), visibility -> finishButton.setVisibility(visibility));
        viewModel.shouldRunUploadManager().observe(getViewLifecycleOwner(), value -> {
            if (value) {
                new UploadManager().upload(requireContext());
            }
        });

        List<QuestionnareBaseFragment> fragmentsToInflate = new QuestionnarePagesListProvider().getQuestionnaryPages(requireContext());
        initViewPager(view, fragmentsToInflate);

        ((MainActivity) requireActivity()).getNavigationView().setVisibility(View.GONE);
        Utils.enableFullscreen(requireActivity());

    }

    QuestionnareFragmentViewModel getViewModel() {
        return viewModel != null ? viewModel : new ViewModelProvider(this).get(QuestionnareFragmentViewModel.class);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (shouldDisableFullscreenAfterFinish) {
            ((MainActivity) requireActivity()).getNavigationView().setVisibility(View.VISIBLE);
            Utils.disableFullscreen(requireActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) requireActivity()).getNavigationView().setVisibility(View.GONE);
        Utils.enableFullscreen(requireActivity());
    }

    ViewPager2 pager;
    private void initViewPager(View view, List<QuestionnareBaseFragment> fragmentsToInflate) {
        pager = view.findViewById(R.id.questionarre_pager);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position - 1 >= 0) {
                    QuestionnareBaseFragment questionnareBaseFragment = ((QuestionnareAdapter) pager.getAdapter()).getItem(position - 1);
                    questionnareBaseFragment.save();
                }
            }

        });
        pagerSize = fragmentsToInflate.size();
        pager.setUserInputEnabled(false);
        pager.setAdapter(new QuestionnareAdapter(this, fragmentsToInflate));
        WormDotsIndicator wormDotsIndicator = view.findViewById(R.id.worm_dot);
        wormDotsIndicator.setViewPager2(pager);
    }

    public void disableNextButton(boolean shouldEnable) {
        int backgroundTint = shouldEnable ? R.color.colorPrimary : R.color.grey_D;
        nextButton.setEnabled(shouldEnable);
        nextButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), backgroundTint)));
    }

    @OnClick(R.id.btn_finish)
    void saveResults() {
        QuestionnareBaseFragment questionnareBaseFragment = ((QuestionnareAdapter) pager.getAdapter()).getItem(pager.getCurrentItem());
        questionnareBaseFragment.save();
        shouldDisableFullscreenAfterFinish = false;
        viewModel.saveQuestionnaryData();
        Toast.makeText(requireContext(), getString(R.string.save_results_success_info), Toast.LENGTH_SHORT).show();
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_questionnareFragment_to_questionnarySumaryFragment);
    }

    @OnClick(R.id.btn_next)
    void nextPage() {
        questionarrePager.setCurrentItem(questionarrePager.getCurrentItem() + 1);
        viewModel.setCurrentPageNumber(questionarrePager.getCurrentItem());
    }

    @OnClick(R.id.btn_back)
    void previousPage() {
        if (questionarrePager.getCurrentItem() - 1 == -1) {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).popBackStack();
        } else {
            questionarrePager.setCurrentItem(questionarrePager.getCurrentItem() - 1);
        }
        viewModel.setCurrentPageNumber(questionarrePager.getCurrentItem());
    }
}
