package com.waldener.archdog;

import android.util.Log;

import com.waldener.arch.ArchViewModel;

public class TttVM extends ArchViewModel {
    private Hello hello = getModel(Hello.class);
    private World world = getModel(World.class);

    private int i = 0;

    void click(){
        Log.i("TttVM", "click");

        hello.setHello("hello " + i);
        postValue(hello);

        world.setWorld("world" + i);
        postValue(world);

        i++;
    }
}
