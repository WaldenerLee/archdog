package com.waldener.archdog.blank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.waldener.arch.BindView;
import com.waldener.archdog.R;
import com.waldener.archdog.blank.model.BlankModel;
import com.waldener.archdog.permission.PermissionFragment;

public class BlankFragment extends PermissionFragment<BlankVM> {
    private TextView tvHello;
    private Button btnClick;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHello = view.findViewById(R.id.tv_hello);
        btnClick = view.findViewById(R.id.btn_click);

        btnClick.setOnClickListener(v -> {
            viewModel.click();
        });
    }

    @SuppressWarnings("unused")
    @BindView(model = BlankModel.class)
    private void onBindView(BlankModel model){
        tvHello.setText(model.getHello());
    }

}
