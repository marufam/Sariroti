package com.developer.amien.sariroti.data.retrofit;

/**
 * Created by amien on 01/05/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetKaryawan {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    private List<Karyawan> karyawan=null;

    public GetKaryawan(String status, Integer jumlah, List<Karyawan> karyawan) {
        this.status = status;
        this.jumlah = jumlah;
        this.karyawan = karyawan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public List<Karyawan> getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(List<Karyawan> karyawan) {
        this.karyawan = karyawan;
    }
}
