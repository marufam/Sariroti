package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amien on 19/05/17.
 */

public class Roti {
    @SerializedName("id_roti")
    @Expose
    private String id_roti;
    @SerializedName("nama_roti")
    @Expose
    private String nama_roti;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("target")
    @Expose
    private String target;

    public Roti(String id_roti, String nama_roti, String harga, String target) {
        this.id_roti = id_roti;
        this.nama_roti = nama_roti;
        this.harga = harga;
        this.target = target;
    }

    public String getId_roti() {
        return id_roti;
    }

    public void setId_roti(String id_roti) {
        this.id_roti = id_roti;
    }

    public String getNama_roti() {
        return nama_roti;
    }

    public void setNama_roti(String nama_roti) {
        this.nama_roti = nama_roti;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
