package com.developer.amien.sariroti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        File f = new File(
                "/data/data/com.developer.amien.sariroti/shared_prefs/MyPref.xml");
        SharedPreferences pref1 = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
//        Toast.makeText(this, ""+pref1.getString("id_karyawan",null).toString(), Toast.LENGTH_SHORT).show();
        if (!f.exists()) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("id_karyawan", "0");
            editor.commit();
            if(pref.getString("id_karyawan",null).equalsIgnoreCase("0")) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(SplashScreen.this, Loginactivity.class);
                        SplashScreen.this.startActivity(mainIntent);
                        SplashScreen.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }else{
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(SplashScreen.this,Menu_utama.class);
                        SplashScreen.this.startActivity(mainIntent);
                        SplashScreen.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
        }else{
            if(pref1.getString("id_karyawan",null).equalsIgnoreCase("0")) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(SplashScreen.this, Loginactivity.class);
                        SplashScreen.this.startActivity(mainIntent);
                        SplashScreen.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }else{
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(SplashScreen.this,Menu_utama.class);
                        SplashScreen.this.startActivity(mainIntent);
                        SplashScreen.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
        }


    }
}
