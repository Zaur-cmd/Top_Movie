package com.example.topmovie.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.topmovie.R;
import com.example.topmovie.api.Result;
import com.example.topmovie.ui.MovieViewModel;

import java.util.List;

public class AdapterPopularMovies extends RecyclerView.Adapter<AdapterPopularMovies.MovieViewHolder> {

    private List<Result> listOfMovies; // null

    public void setMoviesList(List<Result> listOfMovies) {
        this.listOfMovies = listOfMovies;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MovieViewHolder(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_popularmovie, parent, false)

        );
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        if(listOfMovies != null) {

            holder.titleView.setText(listOfMovies.get(position).getOriginal_title());
            holder.textView.setText(listOfMovies.get(position).getTitle());
            Glide.with(holder.imageView)
                    .load("https://image.tmdb.org/t/p/w500/" + listOfMovies.get(position).getPoster_path())
                    .centerCrop()
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        if(listOfMovies != null)
            return listOfMovies.size();
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView titleView;
        TextView r_View;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            r_View = itemView.findViewById(R.id.raiting);
            titleView = itemView.findViewById(R.id.year);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
