package com.waldener.arch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Waldener on 2019/6/27.
 */
public class ArchActivity extends AppCompatActivity {

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this instanceof ArchWrapper){
            ArchViewModel archViewModel = ((ArchWrapper) this).getViewModel();
            if(archViewModel != null){
                archViewModel.getLiveData().observe(this, ((ArchWrapper) this)::onBindView);
            }
        }
    }

}
