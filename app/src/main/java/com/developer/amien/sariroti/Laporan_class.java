package com.developer.amien.sariroti;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetJadwal;
import com.developer.amien.sariroti.data.retrofit.GetKaryawan;
import com.developer.amien.sariroti.data.retrofit.GetLaporan;
import com.developer.amien.sariroti.data.retrofit.GetPenjualan;
import com.developer.amien.sariroti.data.retrofit.GetRoti;
import com.developer.amien.sariroti.data.retrofit.Penjualan;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amien on 10/05/17.
 */

public class Laporan_class extends AppCompatActivity {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    EditText vp[];
    ImageView imageView;
    String imagePath;
    TextInputEditText deskripsi;
    Button button;
    LinearLayout ll;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        verifyStoragePermissions(Laporan_class.this);
        imageView = (ImageView) findViewById(R.id.imageView);
        deskripsi = (TextInputEditText) findViewById(R.id.deskripsi);
        button = (Button) findViewById(R.id.fab);
        ll = (LinearLayout)findViewById(R.id.linearLayout2);
        setTitle("Laporan");
        Intent i = getIntent();
        mApiInterface = ApiClient.GetRoti().create(ApiInterface.class);
        Call<GetRoti> RotiCall = mApiInterface.getRoti();
        RotiCall.enqueue(new Callback<GetRoti>() {
            @Override
            public void onResponse(Call<GetRoti> call, Response<GetRoti> response) {
//                Toast.makeText(Laporan_class.this, ""+response.body().getJumlah(), Toast.LENGTH_SHORT).show();
//                EditText vp[]= new EditText[response.body().getJumlah()];
                TextView v[] = new TextView[response.body().getJumlah()];
                EditText vp[] = new EditText[response.body().getJumlah()];

                for(int i=0;i<response.body().getJumlah();i++){
                    v[i] = new TextView(getApplicationContext());
                    v[i].setText(response.body().getRoti().get(i).getNama_roti());
                    v[i].setPadding(10,10,10,10);
                    v[i].setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    ll.addView(v[i]);

                    vp[i] = new EditText(getApplicationContext());
                    vp[i].setHint("Jumlah Roti");
                    vp[i].setMinLines(1);
                    vp[i].setMaxLines(2);
                    vp[i].setCursorVisible(false);
                    vp[i].setTextColor(Color.BLACK);
                    vp[i].setInputType(InputType.TYPE_CLASS_NUMBER);
                    vp[i].setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    vp[i].setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
                    vp[i].setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
                    vp[i].setEms(10);
                    vp[i].setId(Integer.parseInt(response.body().getRoti().get(i).getId_roti()));
                    vp[i].setPadding(10,10,10,10);

                    ll.addView(vp[i]);
//                    vp[i].setMinLines(1);
//                    vp[i].setMaxLines(3);
//                    vp[i].setId(i);

//                    vp[i].setPadding(10,10,10,10);

//                    ll.addView(vp[i]);
                }


            }

            @Override
            public void onFailure(Call<GetRoti> call, Throwable t) {

            }
        });

//        Toast.makeText(this, "Id_jadwal "+i.getStringExtra("id"), Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(imagePath!=null) {
                    uploadImage();
                    Intent i = new Intent(getApplicationContext(), Menu_utama.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(Laporan_class.this, "Select your photo", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void uploadImage() {

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(Laporan_class.this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        final ApiInterface service = ApiClient.getApiLaporan();

        File file = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Intent i = getIntent();
        String status;
        status = i.getStringExtra("status");
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("foto_laporan", file.getName(), requestFile);
        RequestBody reqid_laporan = MultipartBody.create(MediaType.parse("multipart/form-data"), "");
        RequestBody reqid_jadwal = MultipartBody.create(MediaType.parse("multipart/form-data"), i.getStringExtra("id"));
        RequestBody req_deskripsi = MultipartBody.create(MediaType.parse("multipart/form-data"), deskripsi.getText().toString());
        RequestBody req_status = MultipartBody.create(MediaType.parse("multipart/form-data"), status.toString());
        RequestBody reqaction = MultipartBody.create(MediaType.parse("multipart/form-data"), "POST");


        final Call<GetLaporan> resultCall = service.laporan_insert(body, reqid_laporan,
                reqid_jadwal,
                req_deskripsi,
                req_status,
                reqaction);

        resultCall.enqueue(new Callback<GetLaporan>() {
            @Override
            public void onResponse(Call<GetLaporan> call, Response<GetLaporan> response) {
//                Toast.makeText(Laporan_class.this, "Success "+ll.getChildCount(), Toast.LENGTH_LONG).show();

                for (int i=0;i<ll.getChildCount();i++){
                    View child = ll.getChildAt(i);
                    if(child instanceof EditText){
                        EditText ed = (EditText)child;
                        RequestBody req_idlaporan = MultipartBody.create(MediaType.parse("multipart/form-data"), response.body().getLaporan().get(0).getId_laporan());
                        RequestBody req_idroti = MultipartBody.create(MediaType.parse("multipart/form-data"), String.valueOf(ed.getId()));
                        RequestBody jumlah = MultipartBody.create(MediaType.parse("multipart/form-data"), ed.getText().toString());
//                        Toast.makeText(Laporan_class.this, ""+ed.getId()+": Jumlah "+ ed.getText(), Toast.LENGTH_SHORT).show();
                        mApiInterface = ApiClient.GetPenjualan().create(ApiInterface.class);
                        Call<GetPenjualan> hasilPenjualan = mApiInterface.postPenjualan(req_idlaporan, req_idroti, jumlah);
                        hasilPenjualan.enqueue(new Callback<GetPenjualan>() {
                            @Override
                            public void onResponse(Call<GetPenjualan> call, Response<GetPenjualan> response) {
//                                Toast.makeText(Laporan_class.this, "Penjualan "+response.body().getStatus()+":"+response.body().getJumlah(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<GetPenjualan> call, Throwable t) {

                            }
                        });
                    }
                }
                finish();
            }

            @Override
            public void onFailure(Call<GetLaporan> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal upload "+t.toString(), Toast.LENGTH_LONG).show();
//                progressDialog.dismiss();
//                Toast.makeText(Laporan_class.this, "Insert Success "+t.getCause(), Toast.LENGTH_LONG).show();
//                Log.d("Eror","Insert Message "+t.getCause() );
            }
        });
    }


    public void showImagePopup(View view) {
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);

        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Choose image");
        startActivityForResult(chooserIntent, 100);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100) {
            if (data == null) {
                Toast.makeText(getApplicationContext(),"Unable to pick image",Toast.LENGTH_LONG).show();
                return;
            }

            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);

            imagePath = getRealPathFromURI(imageUri);


        }
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(getApplicationContext(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
