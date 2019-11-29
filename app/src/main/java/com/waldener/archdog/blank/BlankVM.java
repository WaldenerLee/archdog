package com.waldener.archdog.blank;

import com.waldener.arch.ArchViewModel;
import com.waldener.arch.Model;
import com.waldener.archdog.blank.model.HelloModel;
import com.waldener.archdog.blank.model.WorldModel;

public class BlankVM extends ArchViewModel {
    private int i = 0;

    @Model
    private HelloModel helloModel;

    @Model
    private WorldModel worldModel;

    void click(){

        /*
        * 假装此处有一段复杂的业务逻辑
         */

        helloModel.setHello("hello " + i);
        postValue(helloModel);

        worldModel.setWorld("world " + i);
        postValue(worldModel);

        i++;
    }
}
