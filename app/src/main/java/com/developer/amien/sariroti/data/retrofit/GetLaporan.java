package com.developer.amien.sariroti.data.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amien on 01/05/17.
 */

public class GetLaporan {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    private List<Laporan> laporan=null;

    public GetLaporan(String status, Integer jumlah, List<Laporan> laporan) {
        this.status = status;
        this.jumlah = jumlah;
        this.laporan = laporan;
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

    public List<Laporan> getLaporan() {
        return laporan;
    }

    public void setLaporan(List<Laporan> laporan) {
        this.laporan = laporan;
    }
}
