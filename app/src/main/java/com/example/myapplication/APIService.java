package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("search")
    Call<ResponseModel> getSong(@Query("term") String term);
}
