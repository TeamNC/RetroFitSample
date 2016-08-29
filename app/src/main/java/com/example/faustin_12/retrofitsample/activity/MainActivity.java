package com.example.faustin_12.retrofitsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.faustin_12.retrofitsample.R;
import com.example.faustin_12.retrofitsample.RequestInterface;
import com.example.faustin_12.retrofitsample.adapter.DataAdapter;
import com.example.faustin_12.retrofitsample.model.AndroidVersion;
import com.example.faustin_12.retrofitsample.model.Article;
import com.example.faustin_12.retrofitsample.model.Enclosure;
import com.example.faustin_12.retrofitsample.model.JSONResponse;
import com.example.faustin_12.retrofitsample.model.JSONResponsed;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Article> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://rss2json.com") //http://api.learn2crack.com  http://stacktips.com
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponsed> call = request.getJSON();
        call.enqueue(new Callback<JSONResponsed>() {
            @Override
            public void onResponse(Call<JSONResponsed> call, Response<JSONResponsed> response) {

                JSONResponsed jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getArticle()));
                adapter = new DataAdapter(MainActivity.this, data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponsed> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}