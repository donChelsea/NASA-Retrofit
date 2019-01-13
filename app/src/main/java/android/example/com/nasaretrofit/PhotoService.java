package android.example.com.nasaretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoService {
    @GET("api/v1/rovers/curiosity/photos?sol=1&api_key=DEMO_KEY")
    Call<Photo> getPhotoURL();
}
