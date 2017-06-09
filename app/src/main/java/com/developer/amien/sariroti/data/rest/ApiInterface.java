package com.developer.amien.sariroti.data.rest;

import com.developer.amien.sariroti.data.retrofit.GetJadwal;
import com.developer.amien.sariroti.data.retrofit.GetKaryawan;
import com.developer.amien.sariroti.data.retrofit.GetLaporan;
import com.developer.amien.sariroti.data.retrofit.GetLokasi;
import com.developer.amien.sariroti.data.retrofit.GetPenjualan;
import com.developer.amien.sariroti.data.retrofit.GetRoti;
import com.developer.amien.sariroti.data.retrofit.Karyawan;
import com.developer.amien.sariroti.data.retrofit.Laporan;
import com.developer.amien.sariroti.data.retrofit.Penjualan;
import com.developer.amien.sariroti.data.retrofit.Respond;
import com.squareup.picasso.Request;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amien on 01/05/17.
 */

public interface ApiInterface {

    @GET("index.php/karyawan_api")
    Call<GetKaryawan> getKaryawan();

    @GET("index.php/roti_api")
    Call<GetRoti> getRoti();

    @GET("index.php/penjualan_api")
    Call<GetPenjualan> getPenjualan();


    @GET("index.php/karyawan_api")
    Call<GetKaryawan> getKaryawanId(@Query("id") String id);
    @GET("index.php/jadwal_api")
    Call<GetJadwal> getJadwal(@Query("id_karyawan") String id_karyawan);
    @GET("index.php/laporan_api")
    Call<GetLaporan> getLaporan(@Query("id_karyawan") String id_karyawan);
    @GET("index.php/lokasi_api")
    Call<GetLokasi> getLokasi();

    @Multipart
    @POST("index.php/penjualan_api")
    Call<GetPenjualan> postPenjualan(@Part("id_laporan")RequestBody id_laporan,
                                     @Part("id_roti")RequestBody id_roti,
                                     @Part("jumlah_jual")RequestBody jumlah_jual);

    @Multipart
    @POST("index.php/karyawan_api")
    Call<GetKaryawan> uploadImage(@Part MultipartBody.Part foto,
                              @Part("id_karyawan")RequestBody id_karyawan,
                              @Part("nama_karyawan") RequestBody nama_karyawan,
                              @Part("tempat_lahir")RequestBody tempat_lahir,
                              @Part("tgl_lahir")RequestBody tgl_lahir,
                              @Part("alamat")RequestBody alamat,
                              @Part("jk")RequestBody jk,
                              @Part("username")RequestBody username,
                              @Part("password")RequestBody password,
                              @Part("action")RequestBody action);
    @Multipart
    @POST("index.php/karyawan_api")
    Call<GetKaryawan> apiKaryawan_update(
                                  @Part("id_karyawan")RequestBody id_karyawan,
                                  @Part("nama_karyawan") RequestBody nama_karyawan,
                                  @Part("tempat_lahir")RequestBody tempat_lahir,
                                  @Part("tgl_lahir")RequestBody tgl_lahir,
                                  @Part("alamat")RequestBody alamat,
                                  @Part("jk")RequestBody jk,
                                  @Part("username")RequestBody username,
                                  @Part("password")RequestBody password,
                                  @Part("action")RequestBody action);
    @Multipart
    @POST("index.php/laporan_api")
    Call<GetLaporan> laporan_insert(@Part MultipartBody.Part foto_laporan,
                                    @Part("id_laporan")RequestBody id_laporan,
                                    @Part("id_jadwal_laporan")RequestBody id_jadwal_laporan,
                                    @Part("deskripsi")RequestBody deskripsi,
                                    @Part("status")RequestBody status,
                                    @Part("action")RequestBody action
            )
            ;
}
