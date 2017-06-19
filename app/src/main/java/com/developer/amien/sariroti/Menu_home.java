package com.developer.amien.sariroti;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetJadwal;
import com.developer.amien.sariroti.data.retrofit.GetKaryawan;
import com.developer.amien.sariroti.data.retrofit.Jadwal;
import com.developer.amien.sariroti.data.retrofit.Karyawan;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.maps.android.SphericalUtil;
import com.google.maps.android.SphericalUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by amien on 29/04/17.
 */

public class Menu_home extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;
    double myLat=0, myLng=0;
    Location loc;
    LocationManager locationManager;
    String mprovider;
    Circle mapCircle;
    private Marker myMarker;
    ApiInterface mApiInterface;
    //    private LocationManager locationManager;
    private LocationListener listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_menu__home, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();
//        prepareallmap();
        locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
//                t.append("\n " + location.getLongitude() + " " + location.getLatitude());
                if(myLat==0 && myLng==0) {
//                    Toast.makeText(getContext(), "" + location.getLatitude() + "  " + location.getLongitude(), Toast.LENGTH_LONG).show();
                    myLat = location.getLatitude();
                    myLng = location.getLongitude();


                }else{
                    myLat = location.getLatitude();
                    myLng = location.getLongitude();

                }

                if(mapCircle!=null){
                    mapCircle.remove();
                }

//                googleMap.clear();
                    mapCircle = googleMap.addCircle(new CircleOptions()
                            .center(new LatLng(myLat, myLng))
                            .radius(300) //1km=+-10000
                            .strokeColor(Color.argb(90, 255, 189, 31))
                            .fillColor(Color.argb(60, 255, 189, 31))
                            .strokeWidth((float) 2));


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {


            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        configure_button();
        prepareallmap();

        return rootView;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }
    void configure_button(){
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }
            return;
        }


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, listener);
        if(locationManager!=null){
         loc=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            prepareallmap();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareallmap();
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
    public void prepareallmap(){
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    return;
                }
                googleMap.setMyLocationEnabled(true);
                CameraPosition cameraPosition;
                // For dropping a marker at a point on the Map
            if(loc!=null){
                myLat = loc.getLatitude();
                myLng = loc.getLongitude();
            }
                LatLng myLocation = new LatLng(myLat, myLng);
                cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                }
//                Toast.makeText(getContext(), ""+googleMap.getMyLocation().getLatitude(), Toast.LENGTH_SHORT).show();
                CameraPosition PosisiTempat;



                googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {
//                        Toast.makeText(getContext(), ""+googleMap.getMyLocation().getLatitude(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

                mApiInterface = ApiClient.GetJadwal().create(ApiInterface.class);
                Call<GetJadwal> jadwalCall = mApiInterface.getJadwal(pref.getString("id_karyawan",null));
                jadwalCall.enqueue(new Callback<GetJadwal>() {
                    @Override
                    public void onResponse(Call<GetJadwal> call, Response<GetJadwal> response) {
                        final List<Jadwal> jadwalList = response.body().getJadwal();
                        Log.d("Retrofit Get", "Jumlah data : " + String.valueOf(jadwalList.size()));

                        for (int i=0;i<response.body().getJadwal().size();i++) {
                            if(response.body().getJadwal().get(i).getFoto_laporan()==null) {
                                googleMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(Double.parseDouble(jadwalList.get(i).getLatitude()), Double.parseDouble(jadwalList.get(i).getLongtitude())))
                                        .title("Lokasi")
                                        .snippet(jadwalList.get(i).getNama_lokasi())
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
                                        .setTag(jadwalList.get(i));
                                ;

                                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                    @Override
                                    public boolean onMarkerClick(Marker marker) {
                                        final Jadwal k = (Jadwal) marker.getTag();
//                                        Toast.makeText(getContext(), "Jarak "+(SphericalUtil.computeDistanceBetween(new LatLng(myLat, myLng), new LatLng(Double.parseDouble(k.getLatitude()), Double.parseDouble(k.getLongtitude())))), Toast.LENGTH_SHORT).show();
                                          if ((SphericalUtil.computeDistanceBetween(new LatLng(myLat, myLng), new LatLng(Double.parseDouble(k.getLatitude()), Double.parseDouble(k.getLongtitude())))) < 300) {


//                                        Toast.makeText(getContext(), "" + SphericalUtil.computeDistanceBetween(new LatLng(myLat, myLng), new LatLng(Double.parseDouble(k.getLatitude()), Double.parseDouble(k.getLongtitude()))), Toast.LENGTH_SHORT).show();
                                        Snackbar snackbar = Snackbar.make(getView(), "Lokasi " + k.getNama_lokasi(), Snackbar.LENGTH_SHORT)
                                                .setActionTextColor(Color.parseColor("#FFAA00"))
                                                .setAction("Lihat", new View.OnClickListener() {

                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent i = new Intent(getContext(), Laporan_class.class);
                                                        i.putExtra("id", k.getId_jadwal());
                                                        i.putExtra("status", "1");
                                                        startActivity(i);
                                                    }
                                                });
                                        snackbar.show();

                                          }else{
                                              Snackbar snackbar = Snackbar.make(getView(), "Lokasi " + k.getNama_lokasi(), Snackbar.LENGTH_SHORT)
                                                      .setActionTextColor(Color.parseColor("#FFAA00"))
                                                      .setAction("Lihat", new View.OnClickListener() {

                                                          @Override
                                                          public void onClick(View v) {
                                                              Intent i = new Intent(getContext(), Laporan_class.class);
                                                              i.putExtra("id", k.getId_jadwal());
                                                              i.putExtra("status", "0");
                                                              startActivity(i);
                                                          }
                                                      });
                                              snackbar.show();
                                          }
                                        return false;
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GetJadwal> call, Throwable t) {
//                        Toast.makeText(getContext(), "Check your connection (1)", Toast.LENGTH_SHORT).show();
                    }


                });

            }
        });
    }
}
