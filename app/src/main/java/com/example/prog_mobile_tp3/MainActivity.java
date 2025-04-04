package com.example.prog_mobile_tp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button inscriptionButton;
    Button connexionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inscriptionButton = findViewById(R.id.newInscriptionButton);
        connexionButton = findViewById(R.id.connexionButton);

        inscriptionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewInscriptionActivity.class);
            startActivity(intent);
        });

        connexionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConnexionActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}