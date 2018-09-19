package com.example.irfannawawi.mygatetollapp.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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


public class CariActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rv_tol);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        tampilGateTollCari("");
    }

    private void tampilGateTollCari(String key) {
        ApiServices apiServices = InitRetrofit.getInitRetrofit().create(ApiServices.class);
        //Siapkan request
        Call<ResponseTol> tolCall = apiServices.request_cari(key);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cari, menu);
        MenuItem search = menu.findItem(R.id.item_cari);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        searchView.setQueryHint("");
        searchView.setIconified(false);
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName())
        );
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tampilGateTollCari(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tampilGateTollCari(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}