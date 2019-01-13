package android.example.com.nasaretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit != null) {
            return retrofit;
        }
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    private RetrofitSingleton() {}
}
