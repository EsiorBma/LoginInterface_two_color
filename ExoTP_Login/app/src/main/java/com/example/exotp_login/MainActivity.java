package com.example.exotp_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText loginField;
    private EditText passwordField;
    boolean authenticated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginField = findViewById(R.id.username1);
        passwordField = findViewById(R.id.password1);
        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameCheck = loginField.getText().toString();
                String passwordCheck = passwordField.getText().toString();

                if("".equals(usernameCheck) || "".equals(passwordCheck)){
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    // Supposons que vous vérifiez les identifiants avec une méthode d'authentification
                    if (authenticate(usernameCheck, passwordCheck)){
                        authenticated = true;
                    }

                    if (authenticated) {
                        Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Welcome.class);
                        intent.putExtra("USERNAME_KEY", usernameCheck);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Échec de connexion", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean authenticate(String Username, String Password) {
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_KEY");
        String password = intent.getStringExtra("PASSWORD_KEY");

        if (username.equals(Username) && password.equals(Password)) {
            return true; // Retourne 'true' si l'authentification est réussie
        }
        return false;
    }




    public void SignUp(View view) {
        startActivity(new Intent(MainActivity.this, Register.class));
    }
}
