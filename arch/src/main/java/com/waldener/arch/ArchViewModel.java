package com.waldener.arch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Waldener on 2019/6/24.
 */
public abstract class ArchViewModel extends ViewModel {

    private Map<Class<?>, MutableLiveData> liveDataMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    <T> MutableLiveData<T> getLiveData(Class<?> clazz){
        MutableLiveData<T> liveData = liveDataMap.get(clazz);
        if(liveData == null){
            liveData = new MutableLiveData<>();
            T model = newModel(clazz);
            liveData.setValue(model);
            liveDataMap.put(clazz, liveData);
        }
        return liveData;
    }

    @SuppressWarnings("unchecked")
    private <T> T newModel(Class<?> clazz){
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

    void injectModel(){
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            Model annotation = field.getAnnotation(Model.class);
            if(annotation != null){
                field.setAccessible(true);
                try {
                    Class fieldClass = field.getType();
                    Object model = getModel(fieldClass);
                    field.set(this, model);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private  <T> T getModel(Class<?> clazz){
        MutableLiveData<T> liveData = getLiveData(clazz);
        if(liveData != null){
            return liveData.getValue();
        }
       return null;
    }

    protected <T> void postValue(T model){
        if(model != null){
            Class<?> clazz = model.getClass();
            MutableLiveData<T> liveData = getLiveData(clazz);
            if(liveData != null){
                liveData.postValue(model);
            }
        }
    }

}
