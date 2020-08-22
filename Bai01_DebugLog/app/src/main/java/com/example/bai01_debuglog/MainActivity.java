package com.example.bai01_debuglog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG_BAI01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"This is an Error log");
        Log.w(TAG,"This is a Warning log");
        Log.i(TAG,"This is an Information log");
        Log.d(TAG,"This is a Debug log");
        Log.v(TAG,"This is a Verbose log");
    }
}