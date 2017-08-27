package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amien on 19/05/17.
 */

public class GetPenjualan {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    private List<Penjualan> penjualan=null;

    public GetPenjualan(String status, Integer jumlah, List<Penjualan> penjualan) {
        this.status = status;
        this.jumlah = jumlah;
        this.penjualan = penjualan;
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

    public List<Penjualan> getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(List<Penjualan> penjualan) {
        this.penjualan = penjualan;
    }
}
