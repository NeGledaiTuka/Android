package com.telerikacademy.meetup.provider.base;

import com.telerikacademy.meetup.model.base.ILocation;

public abstract class LocationProvider {

    private IOnConnectedListener onConnectedListener;
    private IOnConnectionFailedListener onConnectionFailedListener;
    private IOnLocationChangeListener onLocationChangeListener;

    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public void setOnConnectedListener(IOnConnectedListener onConnectedListener) {
        this.onConnectedListener = onConnectedListener;
    }

    public void setOnConnectionFailedListener(IOnConnectionFailedListener onConnectionFailedListener) {
        this.onConnectionFailedListener = onConnectionFailedListener;
    }

    public void setOnLocationChangeListener(IOnLocationChangeListener onLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener;
    }

    protected IOnConnectedListener getOnConnectedListener() {
        return onConnectedListener;
    }

    protected IOnConnectionFailedListener getOnConnectionFailedListener() {
        return onConnectionFailedListener;
    }

    protected IOnLocationChangeListener getOnLocationChangeListener() {
        return onLocationChangeListener;
    }

    public interface IOnConnectedListener {
        void onConnected(ILocation location);
    }

    public interface IOnConnectionFailedListener {
        void onConnectionFailed(String errorMessage);
    }

    public interface IOnLocationChangeListener {
        void onLocationChange(ILocation location);
    }
}
