package com.abit.hw_4_s3_gr51;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.abit.hw_4_s3_gr51.Film;
import com.abit.hw_4_s3_gr51.R;
import com.abit.hw_4_s3_gr51.databinding.ItemListBinding;
import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<com.abit.hw_4_s3_gr51.Adapter.ViewHolder>{



    interface OnFilmClickListener{
        void onFilmClick(Film film, int position);
    }

    private final OnFilmClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Film> films;

    Adapter(Context context, List<Film> films, OnFilmClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.films = films;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(com.abit.hw_4_s3_gr51.Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Film film = films.get(position);
        holder.img.setImageResource(film.getImg());
        holder.nameView.setText(film.getName());
        //holder.opisanie.setText(film.getOpisan());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onFilmClick(film, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemListBinding binding;
        ImageView img;
        TextView nameView, ratingView, opisanie;
        ViewHolder(View view){
            super(view);
            img = view.findViewById(R.id.iv_img);
            nameView = view.findViewById(R.id.tv_name);
            ratingView = view.findViewById(R.id.tv_rating);

        }
    }
}