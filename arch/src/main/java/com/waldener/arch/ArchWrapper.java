package com.waldener.arch;

import androidx.annotation.Nullable;

/**
 * Created by Waldener on 2019/6/24.
 */
public interface ArchWrapper<VM extends ArchViewModel>{

    @Nullable VM getViewModel();

}
