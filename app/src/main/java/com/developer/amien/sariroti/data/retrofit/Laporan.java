package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amien on 01/05/17.
 */

public class Laporan {
    @SerializedName("id_laporan")
    @Expose
    private String id_laporan;
    @SerializedName("id_jadwal_laporan")
    @Expose
    private String id_jadwal_laporan;
    @SerializedName("foto_karyawan")
    @Expose
    private String foto_karyawan;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("status")
    @Expose
    private String status;

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

    @SerializedName("nama_lokasi")
    @Expose
    private String nama_lokasi;
    @SerializedName("longtitude")
    @Expose
    private String longtitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("foto")
    @Expose
    private String foto;

    public String getFoto_laporan() {
        return foto_laporan;
    }

    public void setFoto_laporan(String foto_laporan) {
        this.foto_laporan = foto_laporan;
    }

    @SerializedName("foto_laporan")
    @Expose
    private String foto_laporan;

    public Laporan(String id_laporan, String id_jadwal_laporan, String foto_karyawan, String deskripsi, String status) {
        this.id_laporan = id_laporan;
        this.id_jadwal_laporan = id_jadwal_laporan;
        this.foto_karyawan = foto_karyawan;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(String id_laporan) {
        this.id_laporan = id_laporan;
    }

    public String getId_jadwal() {
        return id_jadwal_laporan;
    }

    public void setId_jadwal(String id_jadwal_laporan) {
        this.id_jadwal_laporan = id_jadwal_laporan;
    }

    public String getFoto_karyawan() {
        return foto_karyawan;
    }

    public void setFoto_karyawan(String foto_karyawan) {
        this.foto_karyawan = foto_karyawan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getId_jadwal_laporan() {
        return id_jadwal_laporan;
    }

    public void setId_jadwal_laporan(String id_jadwal_laporan) {
        this.id_jadwal_laporan = id_jadwal_laporan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
