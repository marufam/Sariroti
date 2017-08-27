package com.developer.amien.sariroti;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetJadwal;
import com.developer.amien.sariroti.data.retrofit.GetLaporan;
import com.developer.amien.sariroti.data.retrofit.Jadwal;
import com.developer.amien.sariroti.data.retrofit.Laporan;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Menu_Report extends Fragment {
    private RecyclerView mRecycleview;
    private RecyclerView.LayoutManager mLayoutmanager;
    private RecyclerView.Adapter mAdapter;
    private List<Laporan> myLaporan= new ArrayList<>();
    ApiInterface mApiInterface;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_menu__report, container, false);

        mRecycleview = (RecyclerView) rootView.findViewById(R.id.r_history);
        mLayoutmanager = new LinearLayoutManager(rootView.getContext());
        mRecycleview.setLayoutManager(mLayoutmanager);

        SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

        mApiInterface = ApiClient.GetJadwal().create(ApiInterface.class);
        Call<GetLaporan> laporanCall = mApiInterface.getLaporan(pref.getString("id_karyawan",null));
        laporanCall.enqueue(new Callback<GetLaporan>() {
            @Override
            public void onResponse(Call<GetLaporan> call, Response<GetLaporan> response) {
                List<Laporan> laporanList = response.body().getLaporan();
                Log.d("Retrofit Get", "Jumlah data : " + String.valueOf(laporanList.size()));
                for (int i=0;i<response.body().getLaporan().size();i++) {
                    myLaporan.add(laporanList.get(i));
                }
                mAdapter = new Report_adapter(myLaporan, getContext());
                mRecycleview.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetLaporan> call, Throwable t) {
                Toast.makeText(getContext(), "Check your connection", Toast.LENGTH_SHORT).show();
            }


        });



        return rootView;
    }
}
