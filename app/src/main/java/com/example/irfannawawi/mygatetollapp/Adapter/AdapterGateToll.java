package com.example.irfannawawi.mygatetollapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.irfannawawi.mygatetollapp.Activity.DetailActivity;
import com.example.irfannawawi.mygatetollapp.Helper.Konstanta;
import com.example.irfannawawi.mygatetollapp.Model.TolItem;
import com.example.irfannawawi.mygatetollapp.R;

import java.util.List;

public class AdapterGateToll extends RecyclerView.Adapter<AdapterGateToll.MyViewHolder> {
    // Buat Global variable untuk manampung context
    Context context;
    List<TolItem> tolItems;

    public AdapterGateToll(Context context, List<TolItem> data_tol) {
        // Inisialisasi
        this.context = context;
        this.tolItems = data_tol;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Set widget
        holder.tvNamaJalantol.setText(tolItems.get(position).getNamajalantol());
        holder.tvNamaGerbang.setText(tolItems.get(position).getNamagerbang());
        holder.tvNamaKota.setText(tolItems.get(position).getNamakota());

        final String urlGambarBerita = "https://nawdroidtv.000webhostapp.com/images/" + tolItems.get(position).getFoto();
        Glide.with(context)
                .load(urlGambarBerita)
                .apply(new RequestOptions().placeholder(R.mipmap.img_default))
                .into(holder.img_tol);
        final Bundle dataGerbang = new Bundle();
        dataGerbang.putString(Konstanta.DATA_NAMAGERBANG, tolItems.get(position).getNamagerbang());
        dataGerbang.putString(Konstanta.DATA_NAMAJALANTOL, tolItems.get(position).getNamajalantol());
        dataGerbang.putString(Konstanta.DATA_NAMAKOTA, tolItems.get(position).getNamakota());
        dataGerbang.putString(Konstanta.DATA_DESKRIPSI, tolItems.get(position).getDeskripsikota());
        dataGerbang.putString(Konstanta.DATA_LATITUDE, tolItems.get(position).getLatitude());
        dataGerbang.putString(Konstanta.DATA_LONGITUDE, tolItems.get(position).getLongitude());
        dataGerbang.putString(Konstanta.DATA_FOTO, tolItems.get(position).getFoto());
        dataGerbang.putString(Konstanta.DATA_JALANTOLID, tolItems.get(position).getJalantolID());
        dataGerbang.putString(Konstanta.DATA_GERBANGID, tolItems.get(position).getGerbangID());
        dataGerbang.putString(Konstanta.DATA_KOTAID, tolItems.get(position).getKotaID());
        dataGerbang.putString(Konstanta.DATA_ID, tolItems.get(position).getID());


        // Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context, DetailActivity.class);
                varIntent.putExtras(dataGerbang);
                varIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(varIntent);
                Toast.makeText(context, "Terpilih " + tolItems.get(position).getNamagerbang(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount() {
        return tolItems.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi widget
        TextView tvNamaGerbang, tvNamaJalantol, tvNamaKota;
        ImageView img_tol;

        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            tvNamaGerbang = itemView.findViewById(R.id.tvNamaGerbang);
            tvNamaJalantol = itemView.findViewById(R.id.tvNamaJalantol);
            tvNamaKota = itemView.findViewById(R.id.tvNamaKota);
            img_tol = itemView.findViewById(R.id.img_foto);
        }
    }
}