package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amien on 01/05/17.
 */

public class Laporan {
    @SerializedName("id_laporan")
    @Expose
    private String idLaporan;
    @SerializedName("foto_laporan")
    @Expose
    private String fotoLaporan;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("id_karyawan")
    @Expose
    private String idKaryawan;
    @SerializedName("id_lokasi")
    @Expose
    private String idLokasi;
    @SerializedName("nama_karyawan")
    @Expose
    private String namaKaryawan;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("tgl_lahir")
    @Expose
    private String tglLahir;
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
    private String namaLokasi;
    @SerializedName("longtitude")
    @Expose
    private String longtitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public String getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(String idLaporan) {
        this.idLaporan = idLaporan;
    }

    public String getFotoLaporan() {
        return fotoLaporan;
    }

    public void setFotoLaporan(String fotoLaporan) {
        this.fotoLaporan = fotoLaporan;
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(String idLokasi) {
        this.idLokasi = idLokasi;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
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

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
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
