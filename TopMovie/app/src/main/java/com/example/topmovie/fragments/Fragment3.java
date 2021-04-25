package com.example.topmovie.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.topmovie.R;
import com.example.topmovie.api.Result;
import com.example.topmovie.ui.MovieViewModel;

import java.util.List;

public class Fragment3 extends Fragment {
    private MovieViewModel viewModel;
    private AdapterTv adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                if (modelClass == MovieViewModel.class) {
                    return (T) new MovieViewModel();
                }
                return null;
            }
        }).get(MovieViewModel.class);
        adapter = new AdapterTv();

        recyclerView = view.findViewById(R.id.recycler_View3);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
        ));
        recyclerView.setAdapter(adapter);

        viewModel.initTopTv();;
        viewModel.gettvMoviesLiveData().observe(requireActivity(), new Observer() {
            @Override
            public void onChanged(Object o) {
                adapter.setMoviesList((List<Result>) o);
            }
        });
    }
}
