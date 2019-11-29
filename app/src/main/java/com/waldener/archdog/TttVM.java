package com.waldener.archdog;

import android.util.Log;

import com.waldener.arch.ArchViewModel;
import com.waldener.arch.Model;

public class TttVM extends ArchViewModel {

    @Model
    private Hello hello;

    @Model
    private World world;

    private int i = 0;

    void click(){
        Log.i("TttVM", "click");

        hello.setHello("hello " + i);
        postValue(hello);

//        world.setWorld("world" + i);
        world = null;
        postValue(world);

        i++;
    }
}
