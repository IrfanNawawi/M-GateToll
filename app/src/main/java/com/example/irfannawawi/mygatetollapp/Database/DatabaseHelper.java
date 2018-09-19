package com.example.irfannawawi.mygatetollapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.irfannawawi.mygatetollapp.Model.TolItem;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAMA = "gerbang_tol";
    private final static String DATABASE_TABLE = "tb_tol";
    private final static String DATABASE_ID = "ID";
    private final static String kota_ID = "kotaID";
    private final static String nama_Kota = "namaKota";
    private final static String deskripsi_Kota = "deskripsiKota";
    private final static String jalantol_ID = "jalantolID";
    private final static String nama_jalantol = "namajalantol";
    private final static String gerbang_ID = "gerbangID";
    private final static String nama_gerbang = "namagerbang";
    private final static String foto_gerbang = "foto";
    private final static String latitude_gerbang = "latitude";
    private final static String longitude_gerbang = "longitude";

    private final static int DATABASE_VERSION = 1;
    private final static String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE
            + " (" + DATABASE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + kota_ID + " VARCHAR(12), "
            + nama_Kota + " VARCHAR(50), "
            + deskripsi_Kota + " TEXT, "
            + jalantol_ID + " VARCHAR(12), "
            + nama_jalantol + " VARCHAR(50), "
            + gerbang_ID + " VARCHAR(12), "
            + nama_gerbang + " VARCHAR(100), "
            + foto_gerbang + " TEXT, "
            + latitude_gerbang + " VARCHAR(50), "
            + longitude_gerbang + " VARCHAR(50));";
    private static DatabaseHelper instance;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAMA, null, DATABASE_VERSION);
    }

    public static DatabaseHelper initDatabaseHelper(Context context) {
        if (instance != null) {
            return instance;
        }

        return new DatabaseHelper(context);
    }

    public static ArrayList<TolItem> getDataFavorite() {
        ArrayList<TolItem> listGerbangFavorite = new ArrayList<>();
        SQLiteDatabase db = instance.getWritableDatabase();
        String[] columnName = {DATABASE_ID, kota_ID, nama_Kota, jalantol_ID, nama_jalantol, gerbang_ID, nama_gerbang, deskripsi_Kota, foto_gerbang, latitude_gerbang, longitude_gerbang};
        Cursor kursor = db.query(
                DATABASE_TABLE,
                columnName,
                null,
                null,
                null,
                null,
                null);

        if (kursor != null) {
            while (kursor.moveToNext()) {
                int ID = kursor.getInt(kursor.getColumnIndex(DATABASE_ID));
                String kotaID = kursor.getString(kursor.getColumnIndex(kota_ID));
                String namakota = kursor.getString(kursor.getColumnIndex(nama_Kota));
                String jalantolid = kursor.getString(kursor.getColumnIndex(jalantol_ID));
                String namajalantol = kursor.getString(kursor.getColumnIndex(nama_jalantol));
                String gerbangid = kursor.getString(kursor.getColumnIndex(gerbang_ID));
                String namagerbang = kursor.getString(kursor.getColumnIndex(nama_gerbang));
                String deskripsikota = kursor.getString(kursor.getColumnIndex(deskripsi_Kota));
                String fotogerbang = kursor.getString(kursor.getColumnIndex(foto_gerbang));
                String latitudegerbang = kursor.getString(kursor.getColumnIndex(latitude_gerbang));
                String longitudegerbang = kursor.getString(kursor.getColumnIndex(longitude_gerbang));

                TolItem tolItem = new TolItem();
                tolItem.setID(String.valueOf(ID));
                tolItem.setKotaID(kotaID);
                tolItem.setNamakota(namakota);
                tolItem.setJalantolID(jalantolid);
                tolItem.setNamajalantol(namajalantol);
                tolItem.setGerbangID(gerbangid);
                tolItem.setNamagerbang(namagerbang);
                tolItem.setDeskripsikota(deskripsikota);
                tolItem.setFoto(fotogerbang);
                tolItem.setLatitude(latitudegerbang);
                tolItem.setLongitude(longitudegerbang);

                listGerbangFavorite.add(tolItem);

            }
        }

        db.close();
        return listGerbangFavorite;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public long insertData(String namagerbang,
                           String namajalantol,
                           String namaKota,
                           String deskripsiKota,
                           String latitude,
                           String longitude,
                           String foto,
                           String jalantolID,
                           String kotaID,
                           String gerbangID) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(nama_gerbang, namagerbang);
        cv.put(nama_jalantol, namajalantol);
        cv.put(nama_Kota, namaKota);
        cv.put(deskripsi_Kota, deskripsiKota);
        cv.put(latitude_gerbang, latitude);
        cv.put(longitude_gerbang, longitude);
        cv.put(foto_gerbang, foto);
        cv.put(jalantol_ID, jalantolID);
        cv.put(kota_ID, kotaID);
        cv.put(gerbang_ID, gerbangID);
        long id = db.insert(DATABASE_TABLE, null, cv);
        db.close();
        return id;
    }

    public long delete(String namagerbang) {
        SQLiteDatabase db = this.getWritableDatabase();
        String namaKolom = nama_gerbang + " = ?";
        String[] isikolom = {namagerbang};

        int count = db.delete(DATABASE_TABLE, namaKolom, isikolom);
//        db.close();
        return count;
    }
}
