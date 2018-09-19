package com.example.irfannawawi.mygatetollapp.Model;

import com.google.gson.annotations.SerializedName;

public class TolItem {

    @SerializedName("kotaID")
    private String kotaID;

    @SerializedName("jalantolID")
    private String jalantolID;

    @SerializedName("foto")
    private String foto;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("namagerbang")
    private String namagerbang;

    @SerializedName("namajalantol")
    private String namajalantol;

    @SerializedName("ID")
    private String iD;

    @SerializedName("gerbangID")
    private String gerbangID;

    @SerializedName("deskripsikota")
    private String deskripsikota;

    @SerializedName("namakota")
    private String namakota;

    @SerializedName("longitude")
    private String longitude;

    public String getKotaID() {
        return kotaID;
    }

    public void setKotaID(String kotaID) {
        this.kotaID = kotaID;
    }

    public String getJalantolID() {
        return jalantolID;
    }

    public void setJalantolID(String jalantolID) {
        this.jalantolID = jalantolID;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getNamagerbang() {
        return namagerbang;
    }

    public void setNamagerbang(String namagerbang) {
        this.namagerbang = namagerbang;
    }

    public String getNamajalantol() {
        return namajalantol;
    }

    public void setNamajalantol(String namajalantol) {
        this.namajalantol = namajalantol;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getGerbangID() {
        return gerbangID;
    }

    public void setGerbangID(String gerbangID) {
        this.gerbangID = gerbangID;
    }

    public String getDeskripsikota() {
        return deskripsikota;
    }

    public void setDeskripsikota(String deskripsikota) {
        this.deskripsikota = deskripsikota;
    }

    public String getNamakota() {
        return namakota;
    }

    public void setNamakota(String namakota) {
        this.namakota = namakota;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return
                "TolItem{" +
                        "kotaID = '" + kotaID + '\'' +
                        ",jalantolID = '" + jalantolID + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",namagerbang = '" + namagerbang + '\'' +
                        ",namajalantol = '" + namajalantol + '\'' +
                        ",iD = '" + iD + '\'' +
                        ",gerbangID = '" + gerbangID + '\'' +
                        ",deskripsikota = '" + deskripsikota + '\'' +
                        ",namakota = '" + namakota + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}