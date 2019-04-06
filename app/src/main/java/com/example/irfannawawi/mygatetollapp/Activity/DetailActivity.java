package com.example.irfannawawi.mygatetollapp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.irfannawawi.mygatetollapp.Helper.Konstanta;
import com.example.irfannawawi.mygatetollapp.R;

/**
 * Created by USER on 5/2/2018.
 */

public class DetailActivity extends AppCompatActivity {

    String namaGerbang, namaJalantol, namaKota, deskripsiGerbang, fotoGerbang, latGerbang, longGerbang, gerbangID, jalantolID, kotaID;
    ImageView ivFoto;
    TextView tvNamaGerbang, tvNamaJalantol, tvNamaKota, tvDeskripsi;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //menerapkan tool bar sesuai id toolbar | ToolBarAtas adalah variabel buatan sndiri
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inisialisasi
        ivFoto = findViewById(R.id.ivFoto);
        tvNamaGerbang = findViewById(R.id.tvNamaGerbang);
        tvNamaJalantol = findViewById(R.id.tvNamaJalantol);
        tvNamaKota = findViewById(R.id.tvNamaKota);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        fab = findViewById(R.id.fab);

        // Jalankan method tampil detail berita
        showDetailGerbang();

    }

    private void showDetailGerbang() {
        //tangkap data dari intent
        namaGerbang = getIntent().getStringExtra(Konstanta.DATA_NAMAGERBANG);
        namaJalantol = getIntent().getStringExtra(Konstanta.DATA_NAMAJALANTOL);
        namaKota = getIntent().getStringExtra(Konstanta.DATA_NAMAKOTA);
        deskripsiGerbang = getIntent().getStringExtra(Konstanta.DATA_DESKRIPSI);
        fotoGerbang = getIntent().getStringExtra(Konstanta.DATA_FOTO);
        latGerbang = getIntent().getStringExtra(Konstanta.DATA_LATITUDE);
        longGerbang = getIntent().getStringExtra(Konstanta.DATA_LONGITUDE);
        jalantolID = getIntent().getStringExtra(Konstanta.DATA_JALANTOLID);
        gerbangID = getIntent().getStringExtra(Konstanta.DATA_GERBANGID);
        kotaID = getIntent().getStringExtra(Konstanta.DATA_KOTAID);
        //setJudul actionbar/toolbar
        getSupportActionBar().setTitle(namaGerbang);

        //set ke widget
        tvNamaGerbang.setText(namaGerbang);
        tvNamaJalantol.setText("Jalan Tol : " + namaJalantol);
        tvNamaKota.setText("Kota : " + namaKota);
        tvDeskripsi.setText(deskripsiGerbang);

        //untuk gambar gerbang
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.img_default);
        Glide.with(this)
                .load("36.67.240.27:9191/go/img/welcome/welcome1.png")
                .apply(requestOptions)
                .into(ivFoto);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rute Menuju " + getIntent().getStringExtra(Konstanta.DATA_NAMAGERBANG), Toast.LENGTH_SHORT).show();
                route();
            }
        });
    }

    public void route() {
        try {
            Uri gmmIntentUri = Uri.parse("google.navigation:q=" + latGerbang + "," + longGerbang + "");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
