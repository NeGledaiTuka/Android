package com.telerikacademy.meetup.config.di.components;

import com.telerikacademy.meetup.config.di.modules.*;
import com.telerikacademy.meetup.providers.GoogleLocationProvider;
import com.telerikacademy.meetup.ui.components.navigation_drawer.MaterialDrawerItemFactory;
import com.telerikacademy.meetup.ui.fragments.ToolbarFragment;
import com.telerikacademy.meetup.utils.UserSession;
import com.telerikacademy.meetup.views.home.HomeActivity;
import com.telerikacademy.meetup.views.home.HomeContentFragment;
import com.telerikacademy.meetup.views.home.HomeHeaderFragment;
import com.telerikacademy.meetup.views.nearby_venues.NearbyVenuesContentFragment;
import com.telerikacademy.meetup.views.sign_in.SignInActivity;
import com.telerikacademy.meetup.views.sign_up.SignUpActivity;
import dagger.Component;
import okhttp3.OkHttpClient;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AndroidModule.class,
        UtilModule.class,
        ProviderModule.class,
        NetworkModule.class,
        UiModule.class
})
public interface ApplicationComponent {

    void inject(HomeActivity homeActivity);

    void inject(HomeContentFragment homeContentFragment);

    void inject(HomeHeaderFragment homeToolbarFragment);

    void inject(NearbyVenuesContentFragment nearbyVenuesContentFragment);

    void inject(SignInActivity signInActivity);

    void inject(SignUpActivity signUpActivity);

    void inject(GoogleLocationProvider locationProvider);

    void inject(OkHttpClient okHttpClient);

    void inject(UserSession userSession);

    void inject(ToolbarFragment toolbarFragment);

    void inject(MaterialDrawerItemFactory materialDrawerItemFactory);
}