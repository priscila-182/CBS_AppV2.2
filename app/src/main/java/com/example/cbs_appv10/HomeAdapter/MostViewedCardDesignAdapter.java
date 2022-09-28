package com.example.cbs_appv10.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbs_appv10.R;

import java.util.ArrayList;

public class MostViewedCardDesignAdapter extends RecyclerView.Adapter<MostViewedCardDesignAdapter.MostViewedCardDesignViewHolder> {

    ArrayList<MostViewedCardDesignHelpedClass>  mostViewedCardDesignLocations;

    public MostViewedCardDesignAdapter(ArrayList<MostViewedCardDesignHelpedClass> mostViewedCardDesignLocations) {
        this.mostViewedCardDesignLocations = mostViewedCardDesignLocations;
    }

    @NonNull
    @Override
    public MostViewedCardDesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent, false);
        MostViewedCardDesignViewHolder mostViewedCardDesignViewHolder = new MostViewedCardDesignViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedCardDesignViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MostViewedCardDesignViewHolder extends RecyclerView.ViewHolder{

        ImageView image, rating;
        TextView title, desc, author, genre;

        public MostViewedCardDesignViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);
            author = itemView.findViewById(R.id.mv_author);
            genre = itemView.findViewById(R.id.mv_genre);
            rating = itemView.findViewById(R.id.mv_rating);
        }
    }

}
