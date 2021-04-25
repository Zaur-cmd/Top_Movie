package com.example.topmovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.example.topmovie.fragments.Fragment1;
import com.example.topmovie.fragments.Fragment2;
import com.example.topmovie.fragments.Fragment3;
import com.example.topmovie.fragments.FragmentAdapter;
import com.example.topmovie.ui.MovieViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        viewPager = findViewById(R.id.viewpager);
        adapter = new FragmentAdapter(
                getSupportFragmentManager(),
                FragmentAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                fragments
        );
        viewPager.setAdapter(adapter);

    }

}