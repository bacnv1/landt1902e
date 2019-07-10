package com.t3h.testclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET(value = "/getAllUser")
    Call<List<UserProfile>> getAllUser();


}
