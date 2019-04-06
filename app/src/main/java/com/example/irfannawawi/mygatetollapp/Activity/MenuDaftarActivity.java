package com.example.irfannawawi.mygatetollapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.example.irfannawawi.mygatetollapp.R;

public class MenuDaftarActivity extends AppCompatActivity {

    FrameLayout jakarta, bogor, depok, tangerang, bekasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        jakarta = findViewById(R.id.flJakarta);
        jakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jakarta = new Intent(MenuDaftarActivity.this, DaftarJakarta.class);
                startActivity(jakarta);
            }
        });

        bogor = findViewById(R.id.flBogor);
        bogor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bogor = new Intent(MenuDaftarActivity.this, DaftarBogor.class);
                startActivity(bogor);
            }
        });

        depok = findViewById(R.id.flDepok);
        depok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent depok = new Intent(MenuDaftarActivity.this, DaftarDepok.class);
                startActivity(depok);
            }
        });

        tangerang = findViewById(R.id.flTangerang);
        tangerang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tangerang = new Intent(MenuDaftarActivity.this, DaftarTangerang.class);
                startActivity(tangerang);
            }
        });

        bekasi = findViewById(R.id.flBekasi);
        bekasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bekasi = new Intent(MenuDaftarActivity.this, DaftarBekasi.class);
                startActivity(bekasi);
            }
        });
    }
}
