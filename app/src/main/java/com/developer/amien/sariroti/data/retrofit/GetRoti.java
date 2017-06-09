package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amien on 19/05/17.
 */

public class GetRoti {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    private List<Roti> roti=null;

    public GetRoti(String status, Integer jumlah, List<Roti> roti) {
        this.status = status;
        this.jumlah = jumlah;
        this.roti = roti;
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

    public List<Roti> getRoti() {
        return roti;
    }

    public void setRoti(List<Roti> roti) {
        this.roti = roti;
    }
}
