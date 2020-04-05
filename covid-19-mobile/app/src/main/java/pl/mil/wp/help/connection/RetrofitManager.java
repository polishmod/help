package pl.mil.wp.help.connection;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static final String URL = "https://covidhelp.defdev.pl/";
    // Create Logger


    private static OkHttpClient getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        return httpClient.build();
    }

    // Create OkHttp Client
    private static OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
    // Create Retrofit Builder
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient());
    // Create Retrofit Instance
    private static Retrofit retrofit = builder.build();

    public static <T> T buildService(Class<T> type) {
        return retrofit.create(type);
    }
}
