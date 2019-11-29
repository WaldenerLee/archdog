package com.waldener.archdog;

import android.os.Bundle;

import com.waldener.archdog.support.SupportActivity;

public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
