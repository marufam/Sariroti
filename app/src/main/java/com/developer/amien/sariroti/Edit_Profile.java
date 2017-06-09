package com.developer.amien.sariroti;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetKaryawan;
import com.developer.amien.sariroti.data.retrofit.Karyawan;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Edit_Profile extends AppCompatActivity {
    private TextInputEditText nama_karyawan, tempat_lahir, alamat, jk, username, password, foto;
    private TextView tgl_lahir;
    private Button update, ubahfoto;
    ImageView imageView;
    String imagePath;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Edit Profile");
        verifyStoragePermissions(Edit_Profile.this);

        nama_karyawan = (TextInputEditText) findViewById(R.id.nama_karyawan);
        tempat_lahir = (TextInputEditText) findViewById(R.id.tempat_lahir);
        tgl_lahir  = (TextView) findViewById(R.id.tgl_lahir);
        alamat = (TextInputEditText) findViewById(R.id.alamat);
        jk = (TextInputEditText) findViewById(R.id.jk);
        username = (TextInputEditText) findViewById(R.id.username);
        password = (TextInputEditText) findViewById(R.id.password);
        foto = (TextInputEditText) findViewById(R.id.foto);
        update = (Button) findViewById(R.id.update_karyawan);
        ubahfoto = (Button) findViewById(R.id.ubah_foto);
        imageView = (ImageView) findViewById(R.id.imageView);
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        nama_karyawan.setText(pref.getString("nama_karyawan",null));
        tempat_lahir.setText(pref.getString("tempat_lahir",null));
        tgl_lahir.setText(pref.getString("tgl_lahir",null));
        alamat.setText(pref.getString("alamat",null));
        jk.setText(pref.getString("jk",null));
        username.setText(pref.getString("username",null));
        password.setText(pref.getString("password",null));
        foto.setText(pref.getString("foto",null));

        ubahfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);

                final Intent chooserIntent = Intent.createChooser(galleryIntent, "Choose image");
                startActivityForResult(chooserIntent, 100);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imagePath!=null)
                    uploadImage();
                else
                    Toast.makeText(getApplicationContext(),"Please select image", Toast.LENGTH_LONG).show();

            }
        });

    }
    private void uploadImage() {

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(Edit_Profile.this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        ApiInterface service = ApiClient.getApiKaryawan();

        File file = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("foto", file.getName(), requestFile);
        RequestBody reqNamaKaryawan = MultipartBody.create(MediaType.parse("multipart/form-data"), "amien12121");
        RequestBody reqTempatLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), "1996-05-12");
        RequestBody reqTglLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), "1996-05-12");
        RequestBody reqAlamat = MultipartBody.create(MediaType.parse("multipart/form-data"), "Jember");
        RequestBody reqJk = MultipartBody.create(MediaType.parse("multipart/form-data"), "pria");
        RequestBody reqUsername = MultipartBody.create(MediaType.parse("multipart/form-data"), "username");
        RequestBody reqPassword = MultipartBody.create(MediaType.parse("multipart/form-data"), "password");
        RequestBody reqaction = MultipartBody.create(MediaType.parse("multipart/form-data"), "PUT");
        RequestBody reqIdKaryawan = MultipartBody.create(MediaType.parse("multipart/form-data"), "1");

//        Call<GetKaryawan> resultCall = service.postKaryawan_insert(body, reqIdKaryawan,
//                reqNamaKaryawan,
//                reqTempatLahir,
//                reqTglLahir,
//                reqAlamat,
//                reqJk,
//                reqUsername,
//                reqPassword,
//                reqaction);
//
//        resultCall.enqueue(new Callback<GetKaryawan>() {
//            @Override
//            public void onResponse(Call<GetKaryawan> call, Response<GetKaryawan> response) {
//
//                progressDialog.dismiss();
//
//                // Response Success or Fail
//                if (response.isSuccessful()) {
////                    if (response.body().getError()==true)
//
//                    Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
//
////                    else
////                        Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
//
//                } else {
//                    Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
//                }
//
//                imageView.setImageDrawable(null);
//                imagePath = null;
//
//            }
//
//            @Override
//            public void onFailure(Call<GetKaryawan> call, Throwable t) {
//                Log.d("apa",""+t);
//                progressDialog.dismiss();
//            }
//        });
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
         /*
            Uri selectedImageUri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);*/
            imagePath = getRealPathFromURI(imageUri);

            //    Picasso.with(getApplicationContext()).load(new File(imagePath))
            //            .into(imageView);

            //   Toast.makeText(getApplicationContext(),"Please reselect your image",Toast.LENGTH_LONG).show();
           /*     cursor.close();

            } else {

                Toast.makeText(getApplicationContext(),"Unable to load image",Toast.LENGTH_LONG).show();
            }*/
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
