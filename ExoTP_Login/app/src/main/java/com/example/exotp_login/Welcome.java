package com.example.exotp_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView welcomeMessage = findViewById(R.id.welcomelog);
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_KEY");
        welcomeMessage.setText("Bienvenue " + username + " !");
        ImageView retour_v = findViewById(R.id.retour);
        retour_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, MainActivity.class));
            }
        });
    }

}