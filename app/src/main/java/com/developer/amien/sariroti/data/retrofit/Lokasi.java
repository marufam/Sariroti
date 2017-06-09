package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amien on 01/05/17.
 */

public class Lokasi {
    @SerializedName("id_lokasi")
    @Expose
    private String id_lokasi;
    @SerializedName("nama_lokasi")
    @Expose
    private String nama_lokasi;
    @SerializedName("longtitude")
    @Expose
    private String longtitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public Lokasi(String id_lokasi, String nama_lokasi, String longtitude, String latitude) {
        this.id_lokasi = id_lokasi;
        this.nama_lokasi = nama_lokasi;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(String id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
