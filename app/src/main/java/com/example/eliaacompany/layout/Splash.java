package com.example.eliaacompany.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.eliaacompany.R;

import static com.example.eliaacompany.layout.LoginActivity.PREF_NAME;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        final Handler handler = new Handler();

        LoginActivity.SP = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String token = LoginActivity.SP.getString(LoginActivity.TokenKey, "");//"No name defined" is the default value.

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (token != null) {
                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, 2000);
    }

}
