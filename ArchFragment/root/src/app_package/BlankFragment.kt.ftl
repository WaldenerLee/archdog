package ${escapeKotlinIdentifiers(packageName)}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ${getMaterialComponentName('android.arch.lifecycle.ViewModelProviders', useAndroidX)}

<#if applicationPackage??>
import ${applicationPackage}.R
</#if>
import com.waldener.arch.ArchFragment
import com.waldener.arch.ArchWrapper

class ${className} : ArchFragment(), ArchWrapper<${viewModelName}, ${modelName}> {
    private var viewModel: ${viewModelName}? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.${layoutName}, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
        // TODO:
    }

    override fun getViewModel(): ${viewModelName}? {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(this).get(${viewModelName}::class.java)
        }
        return viewModel
    }

    override fun onBindView(model: ${modelName}?) {
        // TODO:
    }

}
