package com.telerikacademy.meetup.provider.base;

public abstract class VenuePhotoProvider implements IVenuePhotoProvider {

    private IOnConnectionFailedListener onConnectionFailedListener;

    public void setOnConnectionFailedListener(IOnConnectionFailedListener onConnectionFailedListener) {
        this.onConnectionFailedListener = onConnectionFailedListener;
    }

    protected IOnConnectionFailedListener getOnConnectionFailedListener() {
        return onConnectionFailedListener;
    }
}
