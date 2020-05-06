package com.example.ui.home.favorites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marvelapp.R;


public class FavoritesFragment extends Fragment {

    public static FavoritesFragment newInstance() {
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        return view;
    }


}
