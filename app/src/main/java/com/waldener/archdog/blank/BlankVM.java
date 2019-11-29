package com.waldener.archdog.blank;

import com.waldener.arch.ArchViewModel;
import com.waldener.arch.Model;
import com.waldener.archdog.blank.model.BlankModel;

public class BlankVM extends ArchViewModel {
    private int i = 0;

    @Model
    private BlankModel blankModel;

    void click(){
        blankModel.setHello("hello " + i++);
        postValue(blankModel);
    }
}
