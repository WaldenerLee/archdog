package com.waldener.archdog;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.waldener.arch.ArchActivity;
import com.waldener.arch.ArchWrapper;
import com.waldener.arch.BindView;

public class MainActivity extends ArchActivity implements ArchWrapper<TttVM> {
    private TttVM tttVM = null;

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
            getViewModel().click();
        });
    }

    @Nullable
    @Override
    public TttVM getViewModel() {
        if(tttVM == null){
            tttVM = ViewModelProviders.of(this).get(TttVM.class);
        }
        return tttVM;
    }

    @SuppressWarnings("unused")
    @BindView(model = Hello.class)
    public void onBindView(Hello hello){
        tvHello.setText(hello.getHello());
    }

    @SuppressWarnings("unused")
    @BindView(model = World.class)
    private void onBindView(World world){
        tvWorld.setText(world.getWorld());
    }
}
