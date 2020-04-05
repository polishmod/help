package pl.mil.wp.help.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.work.ListenableWorker;

import java.io.IOException;
import java.util.List;

import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.connection.location.LocationDto;
import pl.mil.wp.help.connection.location.LocationDtoMapper;
import pl.mil.wp.help.connection.location.LocationResponse;
import pl.mil.wp.help.connection.location.LocationService;
import pl.mil.wp.help.features.location.LocationSynchronizationManager;
import pl.mil.wp.help.room.AppDatabase;
import pl.mil.wp.help.room.entities.location.Location;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;
import pl.mil.wp.help.ui.AcceptDoctorDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private static final String TAG = HomeFragment.class.getSimpleName();

    public static HomeFragment INSTANCE;

    private WebView webView;

    public HomeFragment() {
    }

    public static HomeFragment getInstance() {
        if (INSTANCE == null) {
            synchronized (HomeFragment.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HomeFragment();
                }
            }
        }
        return INSTANCE;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        setWebView(root.findViewById(R.id.webview));
        setJavaScriptEnabled();
        setWebViewClient();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String metInfectedLocation = getArguments().getString(getString(R.string.met_infected_location_extra));
            Log.d(TAG, "getArguments().getString(getString(R.string.met_infected_location_extra) : " + metInfectedLocation);
            loadUrl("http://saturn.wat.edu.pl:9997/leaflet_1.html");
        } else {
            loadUrl("http://saturn.wat.edu.pl:9997/leaflet_0.html");
        }
    }

    private void setWebView(WebView webView) {
        this.webView = webView;
    }

    private void setJavaScriptEnabled() {
        webView.getSettings().setJavaScriptEnabled(true);
    }

    private void setWebViewClient() {
        webView.setWebViewClient(new WebViewClient());
    }

    private void loadUrl(String url) {
        webView.loadUrl(url);
    }

}
