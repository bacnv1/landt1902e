package com.t3h.chat.acitvity.register;

import android.widget.Toast;

import com.t3h.chat.R;
import com.t3h.chat.api.ApiBuilder;
import com.t3h.chat.base.BaseActivity;
import com.t3h.chat.databinding.ActivityRegisterBinding;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> implements RegisterListener, Callback<ResponseBody> {
    @Override
    protected void initAct() {
        binding.setListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onRegisterClicked() {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        String name = binding.edtName.getText().toString();
        if (userName.isEmpty() || password.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Data empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        ApiBuilder.getApi().register(userName, password, name)
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.code() == 200) {
            finish();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Toast.makeText(this, "Register fail", Toast.LENGTH_LONG)
                .show();
    }
}
