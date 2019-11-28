package com.waldener.archdog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.waldener.arch.BindView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @BindView
    public void onBindView(){

    }
}
