package com.t3h.chat.api;

import com.t3h.chat.model.Chat;
import com.t3h.chat.model.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @POST("register.php")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("user_name") String userName,
                                @Field("password") String password,
                                @Field("name") String name);

    @POST("login.php")
    @FormUrlEncoded
    Call<User> login(@Field("user_name") String userName,
                     @Field("password") String password,
                     @Field("token") String token);

    @POST("chat.php")
    @FormUrlEncoded
    Call<ResponseBody> chat(
            @Field("user_name") String userName,
            @Field("message") String message);

    @GET("getchat.php")
    Call<ArrayList<Chat>> getChat();
}
