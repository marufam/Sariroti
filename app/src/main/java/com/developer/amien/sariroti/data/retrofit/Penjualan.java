package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amien on 19/05/17.
 */

public class Penjualan {
    @SerializedName("id_laporan")
    @Expose
    private String id_laporan;
    @SerializedName("id_roti")
    @Expose
    private String id_roti;
    @SerializedName("jumlah_jual")
    @Expose
    private String jumlah_jual;

    @SerializedName("nama_roti")
    @Expose
    private String nama_roti;

    @SerializedName("harga")
    @Expose
    private String harga;

    @SerializedName("target")
    @Expose
    private String target;

    @SerializedName("id_jadwal_laporan")
    @Expose
    private String id_jadwal_laporan;

    @SerializedName("foto_laporan")
    @Expose
    private String foto_laporan;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("status")
    @Expose
    private String status;

    public Penjualan(String id_laporan, String id_roti, String jumlah_jual) {
        this.id_laporan = id_laporan;
        this.id_roti = id_roti;
        this.jumlah_jual = jumlah_jual;
    }

    public String getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(String id_laporan) {
        this.id_laporan = id_laporan;
    }

    public String getId_roti() {
        return id_roti;
    }

    public void setId_roti(String id_roti) {
        this.id_roti = id_roti;
    }

    public String getJumlah_jual() {
        return jumlah_jual;
    }

    public void setJumlah_jual(String jumlah_jual) {
        this.jumlah_jual = jumlah_jual;
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

    public String getId_jadwal_laporan() {
        return id_jadwal_laporan;
    }

    public void setId_jadwal_laporan(String id_jadwal_laporan) {
        this.id_jadwal_laporan = id_jadwal_laporan;
    }

    public String getFoto_laporan() {
        return foto_laporan;
    }

    public void setFoto_laporan(String foto_laporan) {
        this.foto_laporan = foto_laporan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
