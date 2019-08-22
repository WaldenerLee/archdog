package com.waldener.arch;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Waldener on 2019/6/27.
 */
public class ArchFragment extends Fragment {

    @Override
    @SuppressWarnings("unchecked")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(this instanceof ArchWrapper){
            ArchViewModel archViewModel = ((ArchWrapper) this).getViewModel();
            if(archViewModel != null){
                archViewModel.getLiveData().observe(this, ((ArchWrapper) this)::onBindView);
            }
        }
    }

}
