package com.example.prog_mobile_tp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlanningActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private TextView welcome;
    private EditText planning8_10;
    private EditText planning10_12;
    private EditText planning14_16;
    private EditText planning16_18;
    private Button submitButton;
    private int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planning);

        db = new DatabaseHelper(this);
        uid = getIntent().getIntExtra("id", -1);
        if (uid == -1) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        welcome = findViewById(R.id.welcome);
        planning8_10 = findViewById(R.id.planning8_10);
        planning10_12 = findViewById(R.id.planning10_12);
        planning14_16 = findViewById(R.id.planning14_16);
        planning16_18 = findViewById(R.id.planning16_18);

        User user = db.getUser(uid);
        welcome.setText("Welcome " + user.getFirstname() + " " + user.getLastname());
        planning8_10.setText(user.getPlanning_8_10());
        planning10_12.setText(user.getPlanning_10_12());
        planning14_16.setText(user.getPlanning_14_16());
        planning16_18.setText(user.getPlanning_16_18());

        submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(v -> {
            String p8_10 = planning8_10.getText().toString();
            String p10_12 = planning10_12.getText().toString();
            String p14_16 = planning14_16.getText().toString();
            String p16_18 = planning16_18.getText().toString();

            db.updatePlanning(uid, p8_10, p10_12, p14_16, p16_18);

            Intent intent = new Intent(this, AffichagePlanningActivity.class);
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