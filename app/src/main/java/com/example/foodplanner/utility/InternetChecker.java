package com.example.foodplanner.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetChecker {
        private Context context;
        public InternetChecker instance = null;

        private InternetChecker() {
        }

        public InternetChecker getInstance(Context contextInput) {
            if (instance == null) {
                context = contextInput;
                instance = new InternetChecker();
            }
            return instance;
        }
        public InternetChecker getInstance() {
            if (instance == null) {
                instance = new InternetChecker();
            }
            return instance;
        }

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        public Boolean checkIfInternetIsConnected() {
            return ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED));
        }
}
