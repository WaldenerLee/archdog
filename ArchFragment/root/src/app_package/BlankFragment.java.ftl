package ${packageName};

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ${getMaterialComponentName('android.support.annotation.NonNull', useAndroidX)};
import ${getMaterialComponentName('android.support.annotation.Nullable', useAndroidX)};
import ${getMaterialComponentName('android.arch.lifecycle.ViewModelProviders', useAndroidX)};

<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
import com.waldener.arch.ArchFragment;
import com.waldener.arch.ArchWrapper;

public class ${className} extends ArchFragment implements ArchWrapper<${viewModelName}, ${modelName}> {
    private ${viewModelName} viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.${layoutName}, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO:
    }

    @Override
    @Nullable
    public ${viewModelName} getViewModel() {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(this).get(${viewModelName}.class);
        }
        return viewModel;
    }

    @Override
    public void onBindView(@Nullable ${modelName} model) {
        // TODO:
    }

}
