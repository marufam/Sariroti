package com.developer.amien.sariroti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetLaporan;
import com.developer.amien.sariroti.data.retrofit.GetPenjualan;
import com.developer.amien.sariroti.data.retrofit.Laporan;
import com.developer.amien.sariroti.data.retrofit.Penjualan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Laporan_detail extends AppCompatActivity {
    ImageView gambar;
    TextView Nama, Lokasi, Tanggal, Keterangan;
    ApiClient a = new ApiClient(); //buat ngambil alamat

    private RecyclerView mRecycleview;
    private RecyclerView.LayoutManager mLayoutmanager;
    private RecyclerView.Adapter mAdapter;
    private List<Penjualan> mPenjualan= new ArrayList<>();
    ApiInterface mApiInterface;
//    String id_laporan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_laporan_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Detail Laporan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecycleview = (RecyclerView) findViewById(R.id.laporan_roti1);
        mLayoutmanager = new LinearLayoutManager(getApplicationContext());
        mRecycleview.setLayoutManager(mLayoutmanager);

        gambar = (ImageView) findViewById(R.id.gambardetail);
        Nama = (TextView) findViewById(R.id.dnama_karyawan);
        Lokasi = (TextView) findViewById(R.id.dnama_lokasi);
        Tanggal = (TextView) findViewById(R.id.dtanggal);
        Keterangan = (TextView) findViewById(R.id.dketerangan);

        Intent i = getIntent();
        Nama.setText(i.getStringExtra("nama_karyawan"));
//        final String id_laporan = i.getStringExtra("id_laporan");
        Lokasi.setText(i.getStringExtra("nama_lokasi"));
        Tanggal.setText(i.getStringExtra("tanggal"));
        Keterangan.setText(i.getStringExtra("deskripsi"));
        Picasso.with(gambar.getContext())
                .load(a.BASE_URL.toString()+"upload/laporan/"+i.getStringExtra("foto_laporan"))
                .into(gambar);
//        Toast.makeText(this, a.BASE_URL.toString()+"upload/laporan/"+i.getStringExtra("foto_laporan"), Toast.LENGTH_SHORT).show();



        mApiInterface = ApiClient.GetPenjualan().create(ApiInterface.class);
        Call<GetPenjualan> pejualanCall = mApiInterface.getPenjualan();
        pejualanCall.enqueue(new Callback<GetPenjualan>() {

            @Override
            public void onResponse(Call<GetPenjualan> call, Response<GetPenjualan> response) {
//                Log.d("Error===>>>",""+response.body().getPenjualan().size());
                List<Penjualan> penjualanList = response.body().getPenjualan();
                Intent b = getIntent();
                String id_laporan = b.getStringExtra("id_laporan");
//                Toast.makeText(Laporan_detail.this, ""+id_laporan, Toast.LENGTH_SHORT).show();
                Log.d("Error===>>>",""+response.body().getPenjualan().toString());
                for (int i=0;i<response.body().getJumlah();i++) {
//                    Toast.makeText(Laporan_detail.this, ""+response.body().getPenjualan().get(0).getId_laporan(), Toast.LENGTH_SHORT).show();
                    if(response.body().getPenjualan().get(i).getId_laporan().equalsIgnoreCase(id_laporan)) {
                        mPenjualan.add(penjualanList.get(i));
                        Toast.makeText(Laporan_detail.this, "xxx", Toast.LENGTH_SHORT).show();
                    }
                }
                mAdapter = new Penjualan_adapter(mPenjualan, getApplicationContext());
                mRecycleview.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPenjualan> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your connection", Toast.LENGTH_SHORT).show();
            }

//            @Override
//            public void onResponse(Call<GetLaporan> call, Response<GetLaporan> response) {
//                List<Laporan> laporanList = response.body().getLaporan();
//                Log.d("Retrofit Get", "Jumlah data : " + String.valueOf(laporanList.size()));
//                for (int i=0;i<response.body().getLaporan().size();i++) {
//                    myLaporan.add(laporanList.get(i));
//                }
//                mAdapter = new Report_adapter(myLaporan, getContext());
//                mRecycleview.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<GetLaporan> call, Throwable t) {
//                Toast.makeText(getContext(), "Check your connection", Toast.LENGTH_SHORT).show();
//            }


        });

    }

}
