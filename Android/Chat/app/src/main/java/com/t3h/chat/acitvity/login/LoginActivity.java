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
import com.t3h.chat.fcmservice.FCMService;
import com.t3h.chat.model.User;
import com.t3h.chat.utils.SharedUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements LoginListener, Callback<User> {
    private final String KEY_USER_NAME = "key_user_name";
    private final String KEY_PASSWORD = "key_password";

    private SharedUtils shared;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initAct() {
        shared = new SharedUtils(this);
        binding.setListener(this);
        String userName = shared.get(KEY_USER_NAME);
        String password = shared.get(KEY_PASSWORD);
        if (userName.isEmpty() == false
                && password.isEmpty() == false) {
            login(userName, password);
        }
    }

    private void login(String userName, String password) {
        String token  = shared.get(FCMService.KEY_TOKEN);
        ApiBuilder.getApi().login(userName, password, token)
                .enqueue(this);
    }

    @Override
    public void onLoginClicked() {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Data empty", Toast.LENGTH_SHORT).show();
            return;
        }
        login(userName, password);
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
            shared.put(KEY_USER_NAME, user.getUserName());
            shared.put(KEY_PASSWORD, user.getPassword());
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
