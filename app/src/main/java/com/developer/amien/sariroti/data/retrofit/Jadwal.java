package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amien on 01/05/17.
 */

public class Jadwal {
    @SerializedName("id_jadwal")
    @Expose
    private String id_jadwal;

    @SerializedName("id_hari")
    @Expose
    private String id_hari;

    @SerializedName("id_karyawan")
    @Expose
    private String id_karyawan;

    @SerializedName("id_lokasi")
    @Expose
    private String id_lokasi;

    @SerializedName("nama_karyawan")
    @Expose
    private String nama_karyawan;

    @SerializedName("tempat_lahir")
    @Expose
    private String tempat_lahir;

    @SerializedName("tgl_lahir")
    @Expose
    private String tgl_lahir;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("jk")
    @Expose
    private String jk;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("foto")
    @Expose
    private String foto;



    @SerializedName("nama_lokasi")
    @Expose
    private String nama_lokasi;

    @SerializedName("longtitude")
    @Expose
    private String longtitude;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("hari")
    @Expose
    private String hari;

    public Jadwal(String id_jadwal, String id_hari, String id_karyawan, String id_lokasi) {
        this.id_jadwal = id_jadwal;
        this.id_hari = id_hari;
        this.id_karyawan = id_karyawan;
        this.id_lokasi = id_lokasi;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getId_hari() {
        return id_hari;
    }

    public void setId_hari(String id_hari) {
        this.id_hari = id_hari;
    }

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(String id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }
}
