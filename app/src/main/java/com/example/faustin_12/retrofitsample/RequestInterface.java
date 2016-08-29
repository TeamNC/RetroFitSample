package com.example.faustin_12.retrofitsample;

/**
 * Created by FAUSTIN-12 on 02/07/2016.
 */
import com.example.faustin_12.retrofitsample.model.JSONResponse;
import com.example.faustin_12.retrofitsample.model.JSONResponsed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    //@GET("android/jsonandroid")
    //@GET("?json=get_recent_posts&count=45")
    @GET("api.json?rss_url=http://www.eurosport.fr/football/rss.xml")

    Call<JSONResponsed> getJSON();
}