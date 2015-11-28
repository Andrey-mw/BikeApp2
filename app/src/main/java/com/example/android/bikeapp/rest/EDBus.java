package com.example.android.bikeapp.rest;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by Android on 26.11.2015.
 */
public class EDBus extends Bus {
    private static volatile EDBus bus;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private EDBus() {
    }

    public static EDBus getBusInstance() {
        if (bus == null) {
            synchronized (EDBus.class) {
                if (bus == null) {
                    bus = new EDBus();
                }
            }
        }
        return bus;
    }

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    EDBus.super.post(event);
                }
            });
        }
    }
}
