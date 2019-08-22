package com.waldener.arch;

import androidx.annotation.Nullable;

/**
 * Created by Waldener on 2019/6/24.
 */
public interface ArchWrapper<VM extends ArchViewModel<T>, T>{

    @Nullable VM getViewModel();

    void onBindView(@Nullable T t);

}
