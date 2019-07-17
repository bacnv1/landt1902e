package com.t3h.buoi12;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.t3h.buoi12.databinding.ActivitySharedBinding;

public class SharedActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_VALUE = "key_value";
    private ActivitySharedBinding binding;
    private MyShared shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared);
        binding.btnReset.setOnClickListener(this);
        binding.btnSave.setOnClickListener(this);

        shared = new MyShared(this);
        binding.edtValue.setText(shared.get(KEY_VALUE));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_reset:
                shared.reset();
                break;
            case R.id.btn_save:
                shared.put(KEY_VALUE, binding.edtValue.getText().toString());
                break;
        }
    }
}
