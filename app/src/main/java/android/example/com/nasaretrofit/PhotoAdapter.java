package android.example.com.nasaretrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<String> photosList = new ArrayList<>();
    private String photoURL;
    PhotoViewHolder holder;

    public PhotoAdapter(List<String> photosList) {
        this.photosList = photosList;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.photo_listview, viewGroup, false);
        return holder = new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int i) {
        photoViewHolder.onBind(photosList.get(i));
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }


    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
