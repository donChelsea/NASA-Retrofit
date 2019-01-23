package android.example.com.nasaretrofit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    /**
     * BASE_URL is never used here remove it
     * spacePhoto is never used remove it
     */
    private static final String BASE_URL = "https://api.nasa.gov/mars-photos/";
    private ImageView imageView;
    private TextView textView;
    private String spacePhoto;
    private PhotoService photoService;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        imageView = findViewById(R.id.imageview);
        textView = findViewById(R.id.textview);

        Retrofit retrofit = RetrofitSingleton.getInstance();

        photoService = retrofit.create(PhotoService.class);
        Call<Photo> photo = photoService.getPhotoURL();
        photo.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(@NonNull Call<Photo> call, @NonNull Response<Photo> response) {
                recyclerView.setAdapter(new PhotoAdapter(response.body().getPhotoURL()));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                /**
                 * You should be logging your throwable here itll be easier to debug if retrofit is not behaving
                 * as expected
                 */
            }
        });

    }
}
