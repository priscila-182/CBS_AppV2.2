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

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.CategoriasViewHolder> {

    ArrayList<CategoriasHelpedClass> categoriasLocations;

    public CategoriasAdapter(ArrayList<CategoriasHelpedClass> categoriasLocations) {
        this.categoriasLocations = categoriasLocations;
    }

    @NonNull
    @Override
    public CategoriasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoriasViewHolder categoriasViewHolder = new CategoriasViewHolder(view);
        return categoriasViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasViewHolder holder, int position) {

        CategoriasHelpedClass categoriasHelpedClass = categoriasLocations.get(position);
        holder.image.setImageResource(categoriasHelpedClass.getImage());
        holder.title.setText(categoriasHelpedClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return categoriasLocations.size();
    }

    public static class CategoriasViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public CategoriasViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.categories_image);
            title = itemView.findViewById(R.id.categories_title);

        }
    }

}
