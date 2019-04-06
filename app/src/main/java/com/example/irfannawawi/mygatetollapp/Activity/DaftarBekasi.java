package com.example.irfannawawi.mygatetollapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.irfannawawi.mygatetollapp.API.ApiServices;
import com.example.irfannawawi.mygatetollapp.API.InitRetrofit;
import com.example.irfannawawi.mygatetollapp.Adapter.AdapterGateToll;
import com.example.irfannawawi.mygatetollapp.Model.ResponseTol;
import com.example.irfannawawi.mygatetollapp.Model.TolItem;
import com.example.irfannawawi.mygatetollapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarBekasi extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_bekasi);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rv_tol);
        recyclerView.setLayoutManager(new LinearLayoutManager(DaftarBekasi.this));

        tampilGateTollJakarta();
    }

    private void tampilGateTollJakarta() {
        ApiServices apiServices = InitRetrofit.getInitRetrofit().create(ApiServices.class);
        //Siapkan request
        Call<ResponseTol> tolCall = apiServices.request_bekasi();
        //kirim request
        tolCall.enqueue(new Callback<ResponseTol>() {
            @Override
            public void onResponse(Call<ResponseTol> tolcall, Response<ResponseTol> response) {
                // Pasikan response Sukses
                if (response.isSuccessful()) {
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<TolItem> data_tol = response.body().getTol();
                    boolean status = response.body().isStatus();
                    // Kalau response status nya = true
                    if (status) {
                        // Buat Adapter untuk recycler view
                        AdapterGateToll adapter = new AdapterGateToll(getApplicationContext(), data_tol);
                        recyclerView.setAdapter(adapter);
                    } else {
                        // kalau tidak true
                        Toast.makeText(getApplicationContext(), "Tidak ada daftar gerbang tol", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseTol> call, Throwable t) {
                //print ke log jika error
                t.printStackTrace();
            }
        });
    }
}