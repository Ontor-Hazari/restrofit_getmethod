package com.example.post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.post.Model.Apimodel;
import com.example.post.Network.ApiInterface;
import com.example.post.Network.Apiclinet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ApiInterface apiInterface;
    TextView text;
    Retrofit retrofit;

    EditText useridfild,titlefild,textfild;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useridfild = (EditText) findViewById(R.id.useridfild);
        titlefild = (EditText) findViewById(R.id.titlefild);
        textfild = (EditText) findViewById(R.id.textfild);

        button = (Button) findViewById(R.id.button);


        text = (TextView)findViewById(R.id.text);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        retrofit = Apiclinet.getInstanscRegistraion();

        apiInterface = retrofit.create(ApiInterface.class);

        int user = Integer.parseInt(useridfild.getText().toString());

        String title = titlefild.getText().toString();
        String textvalue = textfild.getText().toString();


        Apimodel apimodel = new Apimodel(user,title,textvalue);

        Call<Apimodel > call = apiInterface.createPost(apimodel);


        call.enqueue(new Callback<Apimodel>() {
            @Override
            public void onResponse(Call<Apimodel> call, Response<Apimodel> response) {


                if(!response.isSuccessful())
                {
                    text.setText("code : "+response.body());
                    return;
                }

                Apimodel  apiresposnsce = response.body();

                String content = "";

                content +="ID "+apiresposnsce.getId()+"\n";
                content +="User Id : "+apiresposnsce.getUserid()+"\n";
                content +="Title : "+apiresposnsce.getTitle()+"\n";
                content +="Text : "+apiresposnsce.getText()+"\n";


                text.append(content);


            }

            @Override
            public void onFailure(Call<Apimodel> call, Throwable t) {

            }
        });



    }
}