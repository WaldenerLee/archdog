package com.waldener.arch;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waldener on 2019/6/27.
 */
public class ArchFragment extends Fragment {
    private List<Method> bindViewMethodList = new ArrayList<>();

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

    private void ttt(){
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            BindView annotation = method.getAnnotation(BindView.class);
            if(annotation != null){
                Class modelClass = annotation.model();
                bindViewMethodList.add(method);
            }
        }
    }

}
