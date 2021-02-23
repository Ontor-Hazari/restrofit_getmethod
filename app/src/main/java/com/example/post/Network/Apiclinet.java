package com.example.post.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclinet {
    private static final String BASE_URL ="https://jsonplaceholder.typicode.com/";

    private static Retrofit retrofit = null;

    public static synchronized  Retrofit getInstanscRegistraion()
    {

        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
