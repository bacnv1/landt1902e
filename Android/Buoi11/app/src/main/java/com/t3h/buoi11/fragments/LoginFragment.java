package com.t3h.buoi11.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.t3h.buoi11.MainActivity;
import com.t3h.buoi11.R;

public class LoginFragment extends BaseFragment<MainActivity> implements View.OnClickListener {

    private final String TAG = "LoginFragment";

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUserName = findViewById(R.id.edt_login_user_name);
        edtPassword = findViewById(R.id.edt_login_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    public void setData(String userName, String password){
        edtUserName.setText(userName);
        edtPassword.setText(password);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                break;
            case R.id.btn_register:
                getParentActivity().showFragment(
                        getParentActivity().getFmRegister());
                break;
        }
    }
}
