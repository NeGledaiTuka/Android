package com.telerikacademy.meetup.fragments.base;

import android.support.annotation.MenuRes;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public interface IToolbar {

    void inflateMenu(@MenuRes int menuRes, Menu menu, MenuInflater menuInflater);

    void setNavigationOnClickListener();

    void setNavigationOnClickListener(View.OnClickListener onClickListener);

    // Might be extracted into a separate interface
    void setNavigationDrawer(boolean isUserLoggedIn);
}
