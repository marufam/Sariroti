package com.developer.amien.sariroti;

/**
 * Created by amien on 07/05/17.
 */
import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetKaryawan;
import com.developer.amien.sariroti.data.retrofit.Respond;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Edit_karyawan extends  AppCompatActivity {
    private TextInputEditText nama_karyawan, tempat_lahir, tgl_lahir, alamat,  username, password;
    private RadioButton jk1,jk2;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    SharedPreferences pref;
    ApiClient a = new ApiClient();
    ImageView imageView;
    String imagePath;
    Toolbar toolbar;
    RequestBody reqJk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Edit Profile");
        verifyStoragePermissions(Edit_karyawan.this);

        nama_karyawan = (TextInputEditText) findViewById(R.id.nama_karyawan);
        tempat_lahir = (TextInputEditText) findViewById(R.id.tempat_lahir);
        tgl_lahir  = (TextInputEditText) findViewById(R.id.tgl_lahir);
        alamat = (TextInputEditText) findViewById(R.id.alamat);
//        jk = (TextInputEditText) findViewById(R.id.jk);
        jk1 = (RadioButton) findViewById(R.id.jk1);
        jk2 = (RadioButton) findViewById(R.id.jk2);
        username = (TextInputEditText) findViewById(R.id.username);
        password = (TextInputEditText) findViewById(R.id.password);
        imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.fab);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        ApiInterface mApiInterface = ApiClient.GetKaryawan().create(ApiInterface.class);
        Call<GetKaryawan> karyawanCall = mApiInterface.getKaryawanId(pref.getString("id_karyawan",null));
        karyawanCall.enqueue(new Callback<GetKaryawan>() {

                                 @Override
                                 public void onResponse(Call<GetKaryawan> call, Response<GetKaryawan> response) {
                                     nama_karyawan.setText(response.body().getKaryawan().get(0).getNama_karyawan());
                                     tempat_lahir.setText(response.body().getKaryawan().get(0).getTempat_lahir());
                                     tgl_lahir.setText(response.body().getKaryawan().get(0).getTgl_lahir());
                                     alamat.setText(response.body().getKaryawan().get(0).getAlamat());
                                     if(response.body().getKaryawan().get(0).getJk().equalsIgnoreCase("pria")){
                                         jk1.setChecked(true);

                                     }else if(response.body().getKaryawan().get(0).getJk().equalsIgnoreCase("wanita")){
                                       
                                         jk2.setChecked(true);
                                     }
                                     username.setText(response.body().getKaryawan().get(0).getUsername());
                                     password.setText(response.body().getKaryawan().get(0).getPassword());
                                             Picasso.with(getApplicationContext())
                                            .load(a.BASE_URL.toString()+"upload/karyawan/"+response.body().getKaryawan().get(0).getFoto())
                                            .into(imageView);
                                     Log.d("Title===",a.BASE_URL.toString()+"upload/karyawan/"+response.body().getKaryawan().get(0).getFoto());

                                 }

                                 @Override
                                 public void onFailure(Call<GetKaryawan> call, Throwable t) {
                                     Toast.makeText(Edit_karyawan.this, "Check your Internet connection", Toast.LENGTH_SHORT).show();
                                 }
                             });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(imagePath!=null) {
                    uploadImage();
                    Intent i = new Intent(getApplicationContext(), Menu_utama.class);
                    startActivity(i);
                }else {
                    updatekaryawan();
                    Intent i = new Intent(getApplicationContext(), Menu_utama.class);
                    startActivity(i);
                }

            }
        });
    }
    private void updatekaryawan(){
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(Edit_karyawan.this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        RequestBody reqNamaKaryawan = MultipartBody.create(MediaType.parse("multipart/form-data"), nama_karyawan.getText().toString());
        RequestBody reqTempatLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), tempat_lahir.getText().toString());
        RequestBody reqTglLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), tgl_lahir.getText().toString());
        RequestBody reqAlamat = MultipartBody.create(MediaType.parse("multipart/form-data"), alamat.getText().toString());

        if(jk1.isChecked()==true){
             reqJk= MultipartBody.create(MediaType.parse("multipart/form-data"), "pria");
        }else if(jk2.isChecked()==true){
            reqJk = MultipartBody.create(MediaType.parse("multipart/form-data"), "wanita");
        }
        RequestBody reqUsername = MultipartBody.create(MediaType.parse("multipart/form-data"), username.getText().toString());
        RequestBody reqPassword = MultipartBody.create(MediaType.parse("multipart/form-data"), password.getText().toString());
        RequestBody reqIdKaryawan = MultipartBody.create(MediaType.parse("multipart/form-data"), pref.getString("id_karyawan", null) );
        RequestBody reqaction = MultipartBody.create(MediaType.parse("multipart/form-data"), "PUT");
        ApiInterface mApiInterface = ApiClient.GetKaryawan2().create(ApiInterface.class);
        Call<GetKaryawan> karyawanCall = mApiInterface.apiKaryawan_update(reqIdKaryawan,
                reqNamaKaryawan,
                reqTempatLahir,
                reqTglLahir,
                reqAlamat,
                reqJk,
                reqUsername,
                reqPassword,
                reqaction);

        karyawanCall.enqueue(new Callback<GetKaryawan>() {
            @Override
            public void onResponse(Call<GetKaryawan> call, Response<GetKaryawan> response) {

                        Toast.makeText(Edit_karyawan.this, "Success", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<GetKaryawan> call, Throwable t) {
                progressDialog.dismiss();
//                Toast.makeText(Edit_karyawan.this, "Gagal update", Toast.LENGTH_LONG).show();
                Toast.makeText(Edit_karyawan.this, "Update Success", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void uploadImage() {

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(Edit_karyawan.this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        ApiInterface service = ApiClient.getApiKaryawan();

        File file = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("foto", file.getName(), requestFile);
        RequestBody reqNamaKaryawan = MultipartBody.create(MediaType.parse("multipart/form-data"), nama_karyawan.getText().toString());
        RequestBody reqTempatLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), tempat_lahir.getText().toString());
        RequestBody reqTglLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), tgl_lahir.getText().toString());
        RequestBody reqAlamat = MultipartBody.create(MediaType.parse("multipart/form-data"), alamat.getText().toString());
        if(jk1.isChecked()==true){
            reqJk= MultipartBody.create(MediaType.parse("multipart/form-data"), "pria");
        }else if(jk2.isChecked()==true){
            reqJk = MultipartBody.create(MediaType.parse("multipart/form-data"), "wanita");
        }
        RequestBody reqUsername = MultipartBody.create(MediaType.parse("multipart/form-data"), username.getText().toString());
        RequestBody reqPassword = MultipartBody.create(MediaType.parse("multipart/form-data"), password.getText().toString());
        RequestBody reqIdKaryawan = MultipartBody.create(MediaType.parse("multipart/form-data"), pref.getString("id_karyawan", null) );
        RequestBody reqaction = MultipartBody.create(MediaType.parse("multipart/form-data"), "foto");


        Call<GetKaryawan> resultCall = service.uploadImage(body, reqIdKaryawan,
                reqNamaKaryawan,
                reqTempatLahir,
                reqTglLahir,
                reqAlamat,
                reqJk,
                reqUsername,
                reqPassword,
                reqaction);

        resultCall.enqueue(new Callback<GetKaryawan>() {
            @Override
            public void onResponse(Call<GetKaryawan> call, Response<GetKaryawan> response) {


                Toast.makeText(Edit_karyawan.this, "Success", Toast.LENGTH_LONG).show();
               finish();

            }

            @Override
            public void onFailure(Call<GetKaryawan> call, Throwable t) {
//                Toast.makeText(Edit_karyawan.this, "gagal upload", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                Toast.makeText(Edit_karyawan.this, "Update Success", Toast.LENGTH_LONG).show();
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
