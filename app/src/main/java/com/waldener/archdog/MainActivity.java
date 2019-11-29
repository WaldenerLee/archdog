package com.waldener.archdog;

import android.os.Bundle;

import com.waldener.arch.ArchActivity;

public class MainActivity extends ArchActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @SuppressWarnings("unused")
//    @BindView(model = HelloModel.class)
//    public void onBindView(HelloModel helloModel){
//        tvHello.setText(helloModel.getHello());
//    }
//
//    @SuppressWarnings("unused")
//    @BindView(model = WorldModel.class)
//    private void onBindView(WorldModel worldModel){
//        tvWorld.setText(worldModel.getWorld());
//    }
}
