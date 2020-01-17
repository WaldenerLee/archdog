package com.waldener.arch;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Waldener on 2019/6/27.
 */
public class ArchFragment<VM extends ArchViewModel> extends Fragment {
    protected VM viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArchViewModel archViewModel = getViewModel();
        if(archViewModel != null){
            bindViewModel(archViewModel);
        }
    }

    @SuppressWarnings("unchecked")
    protected VM getViewModel(){
        if(viewModel == null){
            Type type = getClass().getGenericSuperclass();
            if(type != null){
                if(type instanceof ParameterizedType){
                    Type[] actualTypeArguments = ((ParameterizedType)type).getActualTypeArguments();
                    if(actualTypeArguments.length > 0){
                        Class<VM> clazz = (Class<VM>) actualTypeArguments[0];
                        viewModel = ViewModelProviders.of(this).get(clazz);
                    }
                }
            }
        }
        return viewModel;
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
