package com.t3h.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.t3h.chat.adapter.ChatAdapter;
import com.t3h.chat.api.ApiBuilder;
import com.t3h.chat.base.BaseActivity;
import com.t3h.chat.databinding.ActivityMainBinding;
import com.t3h.chat.model.Chat;
import com.t3h.chat.model.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements Callback<ArrayList<Chat>>, View.OnClickListener {
    private ChatAdapter adapter;
    private User user;

    @Override
    protected void initAct() {
        user = (User) getIntent()
                .getSerializableExtra(User.class.getName());
        adapter = new ChatAdapter(this);
        binding.lvChat.setAdapter(adapter);
        getData();

        binding.imSend.setOnClickListener(this);
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ApiBuilder.getApi().getChat()
                            .enqueue(MainActivity.this);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onResponse(Call<ArrayList<Chat>> call, final Response<ArrayList<Chat>> response) {
        adapter.setData(response.body());
        binding.lvChat.post(new Runnable() {
            @Override
            public void run() {
                binding.lvChat.scrollToPosition(response.body().size() - 1);
            }
        });
    }

    @Override
    public void onFailure(Call<ArrayList<Chat>> call, Throwable t) {

    }

    @Override
    public void onClick(View v) {
        String message = binding.edtMessage.getText().toString();
        if (message.isEmpty()) {
            Toast.makeText(this, "Message is empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        ApiBuilder.getApi().chat(user.getUserName(),
                message).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                binding.edtMessage.setText("");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
