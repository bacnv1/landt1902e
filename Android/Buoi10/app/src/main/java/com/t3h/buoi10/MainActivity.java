package com.t3h.buoi10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.t3h.buoi10.api.ApiBuilder;
import com.t3h.buoi10.dao.AppDatabase;
import com.t3h.buoi10.model.News;
import com.t3h.buoi10.model.NewsResponsive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewsResponsive> {

    private EditText edtSearch;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<News> arr = AppDatabase.getInstance(this)
                .getNewsDao().getAll();
        int a = arr.size();
    }

    private void initViews() {
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String keySearch = edtSearch.getText().toString();
        String apiKey = "f70e06a71e524dfa86dbfcf7ca38e62f";
        String language = "vi";

        ApiBuilder.getInstance().getNews(
                keySearch, apiKey, language
        ).enqueue(this);
    }

    @Override
    public void onResponse(Call<NewsResponsive> call, Response<NewsResponsive> response) {
        ArrayList<News> news = response.body().getNews();
        News[] arr = new News[news.size()];
        news.toArray(arr);

        AppDatabase.getInstance(this).getNewsDao()
                .insert(arr);
    }

    @Override
    public void onFailure(Call<NewsResponsive> call, Throwable t) {

    }
}
