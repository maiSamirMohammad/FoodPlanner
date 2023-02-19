package com.example.foodplanner.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class InternetChecker extends LiveData<Boolean> {
    private ConnectivityManager connectivityManager;
    public InternetChecker(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private ConnectivityManager.NetworkCallback getNetworkCallback() {
        return new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                super.onAvailable(network);
                postValue(true);
            }
            @Override
            public void onLost(@NonNull Network network) {
                super.onLost(network);
                postValue(false);
            }
        };
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        try {
            connectivityManager.unregisterNetworkCallback(getNetworkCallback());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActive() {
        super.onActive();
        connectivityManager.registerDefaultNetworkCallback(getNetworkCallback());
    }
}
