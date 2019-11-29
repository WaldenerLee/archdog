package com.waldener.archdog.blank;

import com.waldener.arch.ArchViewModel;
import com.waldener.arch.Model;
import com.waldener.archdog.blank.model.BlankModel;

public class BlankVM extends ArchViewModel {
    private int i = 0;

    @Model
    private BlankModel blankModel;

    void click(){
        /*
        * 假设此处为一段复杂的业务逻辑
         */
        blankModel.setHello("hello " + i++);
        postValue(blankModel);
    }
}
