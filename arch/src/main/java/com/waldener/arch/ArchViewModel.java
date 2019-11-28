package com.waldener.arch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Waldener on 2019/6/24.
 */
public abstract class ArchViewModel<T> extends ViewModel {
    private MutableLiveData<T> liveData;
    private T model;

    private Map<Class<?>, MutableLiveData> liveDataMap;

    MutableLiveData<T> getLiveData(){
        if(liveData == null){
            synchronized (this){
                if(liveData == null){
                    liveData = new MutableLiveData<>();
                    model = newModel();
                    liveData.setValue(model);
                }
            }
        }
        return liveData;
    }

    Map<Class<?>, MutableLiveData> getLiveDataMap(){
        if(liveDataMap == null){
            synchronized (this){
                if(liveDataMap == null){
                    liveDataMap = new HashMap<>();
                }
            }
        }
        return liveDataMap;
    }

    @SuppressWarnings("unchecked")
    private T newModel(){
        Class<?> clazz = (Class<?>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            Constructor constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            return (T) constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void postValue(){
        getLiveData().postValue(model);
    }

    public T getModel(){
        return getLiveData().getValue();
    }

    @SuppressWarnings("unchecked")
    private T newModel(Class<T> clazz){
        try {
            Constructor constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            return (T) constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    MutableLiveData<T> getLiveData(Class<T> clazz){
        MutableLiveData<T> liveData = liveDataMap.get(clazz);
        if(liveData == null){
            liveData = new MutableLiveData<>();
            T model = newModel(clazz);
            liveData.setValue(model);
        }
        return liveData;
    }

    @SuppressWarnings("unchecked")
    public T getModel(Class<T> clazz){
        MutableLiveData<T> liveData = liveDataMap.get(clazz);
        if(liveData != null){
            return liveData.getValue();
        }
       return null;
    }

}
