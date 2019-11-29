package com.waldener.archdog;

import android.util.Log;

import com.waldener.arch.ArchViewModel;
import com.waldener.arch.Model;

public class MainVM extends ArchViewModel {

    @SuppressWarnings("unused")
    @Model
    private HelloModel helloModel;

    @SuppressWarnings("unused")
    @Model
    private WorldModel worldModel;

    private int i = 0;

    void click(){
        Log.i("TttVM", "click");

        helloModel.setHello("hello " + i);
        postValue(helloModel);

        worldModel.setWorld("world" + i);
        postValue(worldModel);

        i++;
    }
}
