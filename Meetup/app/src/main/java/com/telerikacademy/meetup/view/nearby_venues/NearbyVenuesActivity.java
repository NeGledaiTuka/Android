package com.telerikacademy.meetup.view.nearby_venues;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import com.telerikacademy.meetup.BaseApplication;
import com.telerikacademy.meetup.R;
import com.telerikacademy.meetup.config.di.module.ControllerModule;
import com.telerikacademy.meetup.ui.fragments.ToolbarFragment;
import com.telerikacademy.meetup.ui.fragments.base.ISearchBar;
import com.telerikacademy.meetup.view.nearby_venues.base.INearbyVenuesContract;

import javax.inject.Inject;

public class NearbyVenuesActivity extends AppCompatActivity {

    @Inject
    INearbyVenuesContract.Presenter presenter;
    @Inject
    FragmentManager fragmentManager;
    @Inject
    NearbyVenuesRecyclerAdapter recyclerAdapter;

    private NearbyVenuesContentFragment content;
    private ToolbarFragment toolbar;
    private ISearchBar searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_venues);
        injectDependencies();

        toolbar = (ToolbarFragment) fragmentManager
                .findFragmentById(R.id.fragment_nearby_venues_toolbar);

        content = (NearbyVenuesContentFragment) fragmentManager.
                findFragmentById(R.id.fragment_nearby_venues_content);
        content.setAdapter(recyclerAdapter);
        content.setPresenter(presenter);
        presenter.setView(content);

        searchBar = (ISearchBar) fragmentManager
                .findFragmentById(R.id.fragment_nearby_venues_search_header);
        searchBar.setFilter(recyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toolbar.setNavigationDrawer(R.layout.activity_nearby_venues);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        toolbar.inflateMenu(R.menu.main, menu, getMenuInflater());
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