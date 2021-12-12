package com.lazycat.testviewproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainThreadTestActivity extends AppCompatActivity {

    private static final String TAG = MainThreadTestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thread_test);

        View view = new View(this);
        view.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "[view.post] >>>> 1 ");
            }
        });

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "[handler.post] >>>> 2");
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "[runOnUiThread] >>>>> 3");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(TAG, "[runOnUiThread from thread] >>>> 4");
                    }
                });
            }
        }).start();
    }
}