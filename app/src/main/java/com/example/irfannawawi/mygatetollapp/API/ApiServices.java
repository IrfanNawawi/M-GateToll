package com.example.irfannawawi.mygatetollapp.API;


import com.example.irfannawawi.mygatetollapp.Model.ResponseTol;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("search_gerbang.php")
    Call<ResponseTol> request_cari(@Query("key") String keyword);

    @GET("tampil_gerbang.php")
    Call<ResponseTol> request_gerbang();

    @GET("tampil_jakarta.php")
    Call<ResponseTol> request_jakarta();

    @GET("tampil_bogor.php")
    Call<ResponseTol> request_bogor();

    @GET("tampil_depok.php")
    Call<ResponseTol> request_depok();

    @GET("tampil_tangerang.php")
    Call<ResponseTol> request_tangerang();

    @GET("tampil_bekasi.php")
    Call<ResponseTol> request_bekasi();

}
