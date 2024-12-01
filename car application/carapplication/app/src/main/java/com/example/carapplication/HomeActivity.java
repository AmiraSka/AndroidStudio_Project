package com.example.carapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnImmatricule, btnMarque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Remplace par ton layout XML

        btnImmatricule = findViewById(R.id.btnImmatricule);
        btnMarque = findViewById(R.id.btnMarque);

        // Ouvrir ImmatriculeActivity
        btnImmatricule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ImmatriculeActivity.class);
                startActivity(intent);
            }
        });

        // Ouvrir MarqueActivity
        btnMarque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MarqueActivity.class);
                startActivity(intent);
            }
        });
    }
}
