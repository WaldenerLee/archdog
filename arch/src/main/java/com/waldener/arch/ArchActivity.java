package com.waldener.arch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Waldener on 2019/6/27.
 */
public class ArchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this instanceof ArchWrapper){
            ArchViewModel archViewModel = ((ArchWrapper) this).getViewModel();
            if(archViewModel != null){
                bindViewModel(archViewModel);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void bindViewModel(ArchViewModel archViewModel){
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            BindView annotation = method.getAnnotation(BindView.class);
            if(annotation != null){
                method.setAccessible(true);
                Class modelClass = annotation.model();
                MutableLiveData liveData = archViewModel.getLiveData(modelClass);
                liveData.observe(this, model -> {
                    try {
                        method.invoke(this, model);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

}
