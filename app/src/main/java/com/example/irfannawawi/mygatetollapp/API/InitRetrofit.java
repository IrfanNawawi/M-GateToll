package com.example.irfannawawi.mygatetollapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {
    public static String URL_API = "https://nawdroidtv.000webhostapp.com/index.php/";
    public static Retrofit retrofit;

    public static Retrofit getInitRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
