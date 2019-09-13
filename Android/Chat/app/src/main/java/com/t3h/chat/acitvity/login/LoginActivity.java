package com.t3h.chat.acitvity.login;

import android.content.Intent;
import android.widget.Toast;

import com.t3h.chat.MainActivity;
import com.t3h.chat.R;
import com.t3h.chat.acitvity.register.RegisterActivity;
import com.t3h.chat.api.Api;
import com.t3h.chat.api.ApiBuilder;
import com.t3h.chat.base.BaseActivity;
import com.t3h.chat.databinding.ActivityLoginBinding;
import com.t3h.chat.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements LoginListener, Callback<User> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initAct() {
        binding.setListener(this);
    }

    @Override
    public void onLoginClicked() {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Data empty", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiBuilder.getApi().login(userName, password)
                .enqueue(this);
    }

    @Override
    public void onRegisterClicked() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        if (response.code() == 200) {
            Intent intent = new Intent(this, MainActivity.class);
            User user = response.body();
            intent.putExtra(User.class.getName(), user);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show();
    }
}
