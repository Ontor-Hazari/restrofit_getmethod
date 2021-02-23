package com.example.post.Network;

import com.example.post.Model.Apimodel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

   @POST("posts")
    Call<Apimodel> createPost(@Body Apimodel apimodel);
}
