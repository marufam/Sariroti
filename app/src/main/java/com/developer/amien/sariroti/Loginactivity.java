package com.developer.amien.sariroti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.amien.sariroti.data.rest.ApiClient;
import com.developer.amien.sariroti.data.rest.ApiInterface;
import com.developer.amien.sariroti.data.retrofit.GetKaryawan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amien on 01/05/17.
 */

public class Loginactivity extends AppCompatActivity{
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiInterface mApiInterface = ApiClient.GetKaryawan().create(ApiInterface.class);
                Call<GetKaryawan> karyawanCall = mApiInterface.getKaryawan();
                karyawanCall.enqueue(new Callback<GetKaryawan>() {

                    @Override
                    public void onResponse(Call<GetKaryawan> call, Response<GetKaryawan> response) {
//                        Toast.makeText(Loginactivity.this, ""+mEmailView.toString()+"||"+response.body().getKaryawan().get(0).getUsername(), Toast.LENGTH_SHORT).show();
//                        System.out.println("===--->>>"+response.body().getKaryawan().get(0).getUsername()==mEmailView.toString());
//                        Toast.makeText(Loginactivity.this, ""+(response.body().getKaryawan().get(0).getUsername()==mEmailView.toString()), Toast.LENGTH_SHORT).show();
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode where the created file can only be accessed by the calling application
                        SharedPreferences.Editor editor = pref.edit();
                        boolean a=false;
                        Integer index=0;
                        for (int i=0; i<response.body().getJumlah(); i++){
                            if (response.body().getKaryawan().get(i).getUsername().equalsIgnoreCase(mEmailView.getText().toString()) && response.body().getKaryawan().get(i).getPassword().equalsIgnoreCase(mPasswordView.getText().toString())){
                                a=true;
                                index=i;
                                break;

                            }else{
                                a=false;
                            }
                        }
                        if(a==true){
                            Intent mainIntent = new Intent(Loginactivity.this,Menu_utama.class);
                            editor.putString("id_karyawan", response.body().getKaryawan().get(index).getId_karyawan());
                            editor.putString("nama_karyawan", response.body().getKaryawan().get(index).getNama_karyawan());
                            editor.putString("tempat_lahir", response.body().getKaryawan().get(index).getTempat_lahir());
                            editor.putString("tgl_lahir", response.body().getKaryawan().get(index).getTgl_lahir());
                            editor.putString("alamat", response.body().getKaryawan().get(index).getAlamat());
                            editor.putString("jk", response.body().getKaryawan().get(index).getJk());
                            editor.putString("username", response.body().getKaryawan().get(index).getUsername());
                            editor.putString("password", response.body().getKaryawan().get(index).getPassword());
                            editor.putString("foto", response.body().getKaryawan().get(index).getFoto());
                            editor.commit();
                            Loginactivity.this.startActivity(mainIntent);
                            Loginactivity.this.finish();
                        }else{
                            Toast.makeText(Loginactivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<GetKaryawan> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "Check your connection", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    private boolean attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (email!="") {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
        return cancel;
    }



    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 1;
    }
}
