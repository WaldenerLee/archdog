package com.waldener.archdog;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.waldener.arch.ArchActivity;
import com.waldener.arch.BindView;
import com.waldener.archdog.model.HelloModel;
import com.waldener.archdog.model.WorldModel;

public class MainActivity extends ArchActivity<MainVM> {
    private TextView tvHello;
    private TextView tvWorld;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tv_hello);
        tvWorld = findViewById(R.id.tv_world);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            Log.i("MainActivity", "click");
            viewModel.click();
        });
    }

    @SuppressWarnings("unused")
    @BindView(model = HelloModel.class)
    public void onBindView(HelloModel helloModel){
        tvHello.setText(helloModel.getHello());
    }

    @SuppressWarnings("unused")
    @BindView(model = WorldModel.class)
    private void onBindView(WorldModel worldModel){
        tvWorld.setText(worldModel.getWorld());
    }
}
