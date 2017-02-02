package com.telerikacademy.meetup.fragments;

import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;

import com.telerikacademy.meetup.R;
import com.telerikacademy.meetup.interfaces.IMenuInflater;

public class ToolbarFragment extends Fragment
        implements IMenuInflater {

    private ActionBar actionBar;
    private AppCompatActivity currentActivity;
    private Toolbar toolbar;

    public ToolbarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tool_bar, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!(getActivity() instanceof AppCompatActivity)) {
            throw new ClassCastException("Activity must be of type AppCompatActivity in order to support custom Toolbar.");
        }

        this.currentActivity = (AppCompatActivity) getActivity();
        this.toolbar = (Toolbar) this.currentActivity.findViewById(R.id.tool_bar);
        this.currentActivity.setSupportActionBar(toolbar);
        this.actionBar = this.currentActivity.getSupportActionBar();
    }

    public void setNavigationOnClickListener() {
        this.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(currentActivity);
            }
        });
    }

    public void setNavigationOnClickListener(View.OnClickListener clickListener) {
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        this.actionBar.setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(clickListener);
    }

    public void inflateMenu(@MenuRes int menuRes, Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        menu.clear();

        this.currentActivity.getMenuInflater().inflate(menuRes, menu);
    }
}
