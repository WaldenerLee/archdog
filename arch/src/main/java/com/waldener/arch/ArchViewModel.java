package com.waldener.arch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Waldener on 2019/6/24.
 */
public abstract class ArchViewModel<T> extends ViewModel {
    private MutableLiveData<T> liveData;
    private T model;

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

    @SuppressWarnings("unchecked")
    private T newModel(){
        Class<?> clazz = (Class<?>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        ArchModel archModel = clazz.getAnnotation(ArchModel.class);
//        if(archModel != null){
//            try {
//                clazz = Class.forName("com.waldener.arch.model.$model.$" + clazz.getSimpleName());
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
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

}
