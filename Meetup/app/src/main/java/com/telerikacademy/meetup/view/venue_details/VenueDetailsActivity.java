package com.telerikacademy.meetup.view.venue_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import com.telerikacademy.meetup.BaseApplication;
import com.telerikacademy.meetup.R;
import com.telerikacademy.meetup.config.di.module.ControllerModule;
import com.telerikacademy.meetup.model.Venue;
import com.telerikacademy.meetup.ui.fragments.ToolbarFragment;

import javax.inject.Inject;

public class VenueDetailsActivity extends AppCompatActivity {

    @Inject
    FragmentManager fragmentManager;

    private ToolbarFragment toolbar;
    private Venue currentVenue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_details);
        injectDependencies();

        Intent intent = getIntent();
        currentVenue = (Venue) intent.getSerializableExtra("venue");
        setTitle(currentVenue.getName());

        toolbar = (ToolbarFragment) fragmentManager
                .findFragmentById(R.id.fragment_toolbar);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        if (toolbar != null) {
            toolbar.inflateMenu(R.menu.main, menu, getMenuInflater());
            toolbar.setNavigationOnClickListener();
        }

        return true;
    }

    private void injectDependencies() {
        BaseApplication
                .from(this)
                .getComponent()
                .getControllerComponent(new ControllerModule(
                        this, getSupportFragmentManager()
                ))
                .inject(this);
    }
}