package com.waldener.arch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Waldener on 2019/6/27.
 */
public class ArchViewModel extends ViewModel {

    private Map<Class<?>, MutableLiveData> liveDataMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    <T> MutableLiveData<T> getLiveData(Class<?> clazz){
        MutableLiveData<T> liveData = liveDataMap.get(clazz);
        if(liveData == null){
            liveData = new MutableLiveData<>();
            liveDataMap.put(clazz, liveData);
        }
        return liveData;
    }

    /**
     * postValue
     * @param model
     * @param <T>
     */
    protected <T> void postValue(T model){
        if(model != null){
            Class<?> clazz = model.getClass();
            MutableLiveData<T> liveData = getLiveData(clazz);
            if(liveData != null){
                liveData.postValue(model);
            }
        }
    }

    /**
     * setValue
     * @param model
     * @param <T>
     */
    protected <T> void setValue(T model){
        if(model != null){
            Class<?> clazz = model.getClass();
            MutableLiveData<T> liveData = getLiveData(clazz);
            if(liveData != null){
                liveData.setValue(model);
            }
        }
    }

}
