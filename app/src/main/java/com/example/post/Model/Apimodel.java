package com.example.post.Model;

import com.google.gson.annotations.SerializedName;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apimodel {


            private  int userid;
           private Integer  id;
            private  String title;

    public Apimodel(int userid, String title, String text) {
        this.userid = userid;
        this.title = title;
        this.text = text;
    }

    @SerializedName("body")
            private  String text;



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
