package com.telerikacademy.meetup.view.favorite_venues;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telerikacademy.meetup.R;

public class FavoriteVenuesContentFragment extends Fragment {

    public FavoriteVenuesContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_favorite_venues_content, container, false);
    }
}
