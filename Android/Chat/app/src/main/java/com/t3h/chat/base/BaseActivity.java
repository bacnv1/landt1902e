package com.t3h.chat.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity <DB extends ViewDataBinding> extends AppCompatActivity {
    protected DB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                getLayoutId());
        initAct();
    }

    protected abstract void initAct();

    protected abstract int getLayoutId();
}
