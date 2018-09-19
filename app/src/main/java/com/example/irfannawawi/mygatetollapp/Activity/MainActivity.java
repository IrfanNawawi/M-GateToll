package com.example.irfannawawi.mygatetollapp.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.irfannawawi.mygatetollapp.Fragment.FragmentSlider;
import com.example.irfannawawi.mygatetollapp.Fragment.SliderIndicator;
import com.example.irfannawawi.mygatetollapp.Fragment.SliderPagerAdapter;
import com.example.irfannawawi.mygatetollapp.Fragment.SliderView;
import com.example.irfannawawi.mygatetollapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    private MediaPlayer mediaPlayer;
    private LinearLayout daftargerbang, petagerbang, carigerbang, beritalalin, tentangkami, hubungikami;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);

        daftargerbang = (LinearLayout) findViewById(R.id.daftar_gerbang);
        daftargerbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(MainActivity.this, MenuDaftarActivity.class);
                startActivity(daftar);
            }
        });
        petagerbang = (LinearLayout) findViewById(R.id.peta_gerbang);
        petagerbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent peta = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(peta);
            }
        });
        carigerbang = (LinearLayout) findViewById(R.id.cari_gerbang);
        carigerbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cari = new Intent(MainActivity.this, InputGerbang.class);
                startActivity(cari);
            }
        });
        beritalalin = (LinearLayout) findViewById(R.id.berita_lalin);
        beritalalin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent berita = new Intent(MainActivity.this, BeritaLalinActivity.class);
                startActivity(berita);
            }
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.ost);
        tentangkami = (LinearLayout) findViewById(R.id.tentang);
        tentangkami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                View alertLayout = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup_tentang, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setView(alertLayout);
                alert.setCancelable(true);

                final AlertDialog dialog = alert.create();
                dialog.show();

                final TextView tvYes = (TextView) alertLayout.findViewById(R.id.tvOK);
                tvYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }
        });
        hubungikami = (LinearLayout) findViewById(R.id.hubungi);
        hubungikami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alertLayout = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup_hubungi, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setView(alertLayout);
                alert.setCancelable(true);

                final AlertDialog dialog = alert.create();
                dialog.show();

                final ImageView telp = (ImageView) alertLayout.findViewById(R.id.img_tlp);
                telp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:081285728759"));
                        startActivity(callIntent);
                    }
                });

                final ImageView email = (ImageView) alertLayout.findViewById(R.id.img_email);
                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:irfnawi@gmail.com"));
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Kritik dan Saran Untuk aplikasi M-GateToll");
                        intent.putExtra(Intent.EXTRA_TEXT, "Silahkan Masukkan Kritik dan Saran nya");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });
            }
        });

        setupSlider();
    }

    private void setupSlider() {
        sliderView.setDurationScroll(500);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://wisatanasional.net/wp-content/uploads/2017/11/Wisata-Nasional-Taman-Monas-Jakarta-750x375.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.joybizer.com/wp-content/uploads/2018/07/joybiz-bogor.jpg"));
        fragments.add(FragmentSlider.newInstance("https://i.ytimg.com/vi/hUtfCPn-fmU/maxresdefault.jpg"));
        fragments.add(FragmentSlider.newInstance("http://3.bp.blogspot.com/-viyKBoTpTU0/VGm0GM1vnhI/AAAAAAAAAfI/Abvb-fnEA7E/s1600/10509682.jpg"));
        fragments.add(FragmentSlider.newInstance("https://emosijiwaku.com/wp-content/uploads/2017/11/stadion-patriot.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(MainActivity.this, mLinearLayout, sliderView, R.drawable.bg_indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
