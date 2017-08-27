package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amien on 01/05/17.
 */

public class GetLokasi {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    private List<Lokasi> lokasi=null;

    public GetLokasi(String status, Integer jumlah, List<Lokasi> lokasi) {
        this.status = status;
        this.jumlah = jumlah;
        this.lokasi = lokasi;
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

    public List<Lokasi> getLokasi() {
        return lokasi;
    }

    public void setLokasi(List<Lokasi> lokasi) {
        this.lokasi = lokasi;
    }
}
