package com.waldener.archdog.blank;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.waldener.arch.BindView;
import com.waldener.archdog.R;
import com.waldener.archdog.blank.model.HelloModel;
import com.waldener.archdog.blank.model.WorldModel;
import com.waldener.archdog.permission.PermissionFragment;

public class BlankFragment extends PermissionFragment<BlankVM> {
    private TextView tvHello;
    private TextView tvWorld;
    private Button btnClick;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHello = view.findViewById(R.id.tv_hello);
        tvWorld = view.findViewById(R.id.tv_world);
        btnClick = view.findViewById(R.id.btn_click);

        btnClick.setOnClickListener(v -> {
            viewModel.click();
        });
    }

    @SuppressWarnings("unused")
    @BindView(model = HelloModel.class)
    private void onBindView(HelloModel model){
        Log.i(TAG, model.toString() + ", hashcode: " + model.hashCode());
        tvHello.setText(model.getHello());
    }

    @SuppressWarnings("unused")
    @BindView(model = WorldModel.class)
    private void onBindView(WorldModel model){
        Log.i(TAG, model.toString() + ", hashcode: " + model.hashCode());
        tvWorld.setText(model.getWorld());
    }

}
