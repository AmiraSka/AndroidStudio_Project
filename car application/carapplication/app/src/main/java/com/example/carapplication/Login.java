package com.example.carapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database(this); // Initialisation de la base de données

        final EditText phone = findViewById(R.id.Mobile);
        final EditText password = findViewById(R.id.Password);
        final Button loginBtn = findViewById(R.id.LoginBtn);
        final TextView registerNowBtn = findViewById(R.id.RegisterNowBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneTxt = phone.getText().toString().trim();
                String passwordTxt = password.getText().toString().trim();

                Log.d("LOGIN_ATTEMPT", "Phone: " + phoneTxt + ", Password: " + passwordTxt);

                if (phoneTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your mobile or password", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isValid = db.checkUserCredentials(phoneTxt, passwordTxt);
                    if (isValid) {
                        Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, HomeActivity.class));
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUpActivity.class));
            }
        });
    }
}





