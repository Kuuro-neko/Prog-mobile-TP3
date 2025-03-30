package com.example.prog_mobile_tp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AffichagePlanningActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private int uid;
    private TextView planning8_10;
    private TextView planning10_12;
    private TextView planning14_16;
    private TextView planning16_18;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_affichage_planning);

        db = new DatabaseHelper(this);

        uid = getIntent().getIntExtra("id", -1);
        if (uid == -1) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        planning8_10 = findViewById(R.id.planning8_10);
        planning10_12 = findViewById(R.id.planning10_12);
        planning14_16 = findViewById(R.id.planning14_16);
        planning16_18 = findViewById(R.id.planning16_18);

        User user = db.getUser(uid);

        planning8_10.setText(user.getPlanning_8_10());
        planning10_12.setText(user.getPlanning_10_12());
        planning14_16.setText(user.getPlanning_14_16());
        planning16_18.setText(user.getPlanning_16_18());

        returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlanningActivity.class);
            intent.putExtra("id", uid);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}