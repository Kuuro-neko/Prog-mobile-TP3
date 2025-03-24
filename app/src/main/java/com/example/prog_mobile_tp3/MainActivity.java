package com.example.prog_mobile_tp3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements InscriptionFragment.OnInscriptionListener {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        InscriptionFragment inscriptionFragment = new InscriptionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, inscriptionFragment).commit();
    }

    @Override
    public void onInscriptionListener(String login, String password, String lastname, String firstname, String birthdate, String phone, String email, String interests) {
        System.out.println("Login: " + login + "\nPassword: " + password + "\nLastname: " + lastname + "\nFirstname: " + firstname + "\nBirthdate: " + birthdate + "\nPhone: " + phone + "\nEmail: " + email + "\nInterests: " + interests);
        // Store data adn then go to the next fragment with the data
        databaseHelper.insertUser(login, password, lastname, firstname, birthdate, phone, email, interests);

        AffichageFragment affichageFragment = new AffichageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("login", login);
        bundle.putString("password", password);
        bundle.putString("lastname", lastname);
        bundle.putString("firstname", firstname);
        bundle.putString("birthdate", birthdate);
        bundle.putString("phone", phone);
        bundle.putString("email", email);
        bundle.putString("interests", interests);
        affichageFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, affichageFragment).commit();

    }
}