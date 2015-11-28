package com.example.android.bikeapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Android on 19.11.2015.
 */
public class MyService extends IntentService {

   public String TAG = "Service";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyService() {
        super("name1");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {

        }

        Log.i(TAG, "Start onHandleIntent " + intent.getStringExtra("name"));

    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Log.i(TAG, "onCreate");
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//
//        Log.i(TAG, "OnStsrtCommand");
//        Thread thread = new Thread() {
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    Log.i(TAG, "10000");
//                    stopSelf();
//                    Log.i(TAG, "stopSelf");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                }
//            }
//        };
//        thread.start();
//
//
//        return Service.START_REDELIVER_INTENT;
//    }
//
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
//
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
}
