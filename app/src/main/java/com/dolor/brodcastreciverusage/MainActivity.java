package com.dolor.brodcastreciverusage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    DynamicReciver dynamicReciver;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        dynamicReciver = new DynamicReciver();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"AToas",Toast.LENGTH_SHORT).show();
        registerReceiver(dynamicReciver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(dynamicReciver);
    }

    private class DynamicReciver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(),intent.getAction(),Toast.LENGTH_SHORT).show();
        }
    }
}
