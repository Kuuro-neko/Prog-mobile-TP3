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

import com.example.prog_mobile_tp3.exceptions.LoginRulesException;
import com.example.prog_mobile_tp3.exceptions.PasswordRulesException;

public class ConnexionActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_connexion);

        db = new DatabaseHelper(this);

        loginEditText = findViewById(R.id.login);
        passwordEditText = findViewById(R.id.password);
        submitButton = findViewById(R.id.submit);
        errorTextView = findViewById(R.id.message);

        submitButton.setOnClickListener(v -> {
            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            try {
                int id = db.logIn(login, password);
                if (id != -1) {
                    Intent intent = new Intent(this, PlanningActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    errorTextView.setText("Login or password incorrect");
                }
            } catch (LoginRulesException | PasswordRulesException e) {
                errorTextView.setText(e.toString());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}