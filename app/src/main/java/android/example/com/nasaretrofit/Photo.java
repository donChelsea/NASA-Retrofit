package android.example.com.nasaretrofit;

import java.util.List;

public class Photo {
    private List<String> photoURL;
    private String earthDate;

    public Photo(List<String> photoURL, String earthDate) {
        this.photoURL = photoURL;
        this.earthDate = earthDate;
    }

    public List<String> getPhotoURL() {
        return photoURL;
    }

    public String getEarthDate() {
        return earthDate;
    }
}
