package com.t3h.buoi10.api;

import com.t3h.buoi10.model.NewsResponsive;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("everything")
    Call<NewsResponsive> getNews(
            @Query("q") String keySearch,
            @Query("apiKey") String key,
            @Query("language") String lan
    );
}
