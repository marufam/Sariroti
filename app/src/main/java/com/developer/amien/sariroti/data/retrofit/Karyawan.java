package com.developer.amien.sariroti.data.retrofit;

/**
 * Created by amien on 01/05/17.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Karyawan {
    @SerializedName("id_karyawan")
    @Expose
    private String id_karyawan;
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

    public Karyawan(String id_karyawan, String nama_karyawan, String tempat_lahir, String tgl_lahir, String alamat, String jk, String username, String password, String foto) {

        this.id_karyawan = id_karyawan;
        this.nama_karyawan = nama_karyawan;
        this.tempat_lahir = tempat_lahir;
        this.tgl_lahir = tgl_lahir;
        this.alamat = alamat;
        this.jk = jk;
        this.username = username;
        this.password = password;
        this.foto = foto;
    }

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
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
}
