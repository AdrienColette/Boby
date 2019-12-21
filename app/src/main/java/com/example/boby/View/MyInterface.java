package com.example.boby.View;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface  {

    public static String JSONURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/";
        //";

    @GET("json_parsing.php")
        //"j")
    Call<String> getString();
}
