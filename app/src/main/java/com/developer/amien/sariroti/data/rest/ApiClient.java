package com.developer.amien.sariroti.data.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amien on 01/05/17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.213/sariroti/";

    private static Retrofit retrofit = null;
    public static Retrofit GetKaryawan() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getApiKaryawan(){
        return GetKaryawan().create(ApiInterface.class);
    }


    private static Retrofit retrofit_karyawan = null;
    public static Retrofit GetKaryawan2() {
        if (retrofit_karyawan==null) {
            retrofit_karyawan = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit_karyawan;
    }

    private static Retrofit retrofit_jadwal = null;
    public static Retrofit GetJadwal() {
        if (retrofit_jadwal==null) {
            retrofit_jadwal = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit_jadwal;
    }

    private static Retrofit retrofit_laporan = null;
    public static Retrofit GetLaporan() {
        if (retrofit_laporan==null) {
            retrofit_laporan = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit_laporan;
    }

    private static Retrofit foto_laporan = null;
    public static Retrofit GetLaporanfoto() {
        if (foto_laporan==null) {
            foto_laporan = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return foto_laporan;
    }
    public static ApiInterface getApiLaporan(){
        return GetLaporanfoto().create(ApiInterface.class);
    }



    private static Retrofit retrofit_lokasi = null;
    public static Retrofit GetLokasi() {
        if (retrofit_lokasi==null) {
            retrofit_lokasi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit_lokasi;
    }

    private static Retrofit retrofit_roti = null;
    public static Retrofit GetRoti() {
        if (retrofit_roti==null) {
            retrofit_roti = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit_roti;
    }

    private static Retrofit retofit_penjualan = null;
    public static Retrofit GetPenjualan() {
        if (retofit_penjualan==null) {
            retofit_penjualan = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retofit_penjualan;
    }
}
