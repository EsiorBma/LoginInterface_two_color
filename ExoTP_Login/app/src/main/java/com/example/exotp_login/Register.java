package com.example.exotp_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Register extends AppCompatActivity {
    private EditText signField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signField = findViewById(R.id.username_input);
        passwordField = findViewById(R.id.password_input);
        Button Toastbutton = findViewById(R.id.Signbtn);
        Toastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signIn = signField.getText().toString();
                String password = passwordField.getText().toString();
                if("".equals(signIn) || "".equals(password)){
                    Toast.makeText(Register.this, "Information incomplète", Toast.LENGTH_SHORT).show();
                }else{
                    // Après que l'utilisateur ait entré ses informations et cliqué sur le bouton d'inscription
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    intent.putExtra("USERNAME_KEY", signIn); // 'signIn' est la variable contenant le nom d'utilisateur entré
                    intent.putExtra("PASSWORD_KEY", password); // 'password' est la variable contenant le mot de passe entré
                    Toast.makeText(Register.this, "Inscription réussie", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });

    }

    public void SignIn(View view) {
        startActivity(new Intent(Register.this, MainActivity.class));
    }


}