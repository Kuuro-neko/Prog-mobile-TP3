package com.example.prog_mobile_tp3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prog_mobile_tp3.exceptions.LoginRulesException;
import com.example.prog_mobile_tp3.exceptions.PasswordRulesException;
import com.example.prog_mobile_tp3.exceptions.UserAlreadyExistsException;

public class NewInscriptionActivity extends AppCompatActivity implements InscriptionFragment.OnInscriptionListener {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newinscription);

        databaseHelper = new DatabaseHelper(this);

        InscriptionFragment inscriptionFragment = new InscriptionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, inscriptionFragment).commit();
    }

    @Override
    public void onInscriptionListener(String login, String password, String lastname, String firstname, String birthdate, String phone, String email, String interests, android.widget.TextView errorTextView) {
        System.out.println("From mainactivity (about to add this new user) : Login: " + login + "\nPassword: " + password + "\nLastname: " + lastname + "\nFirstname: " + firstname + "\nBirthdate: " + birthdate + "\nPhone: " + phone + "\nEmail: " + email + "\nInterests: " + interests);
        // Store data adn then go to the next fragment with the data
        try {
            databaseHelper.insertUser(login, password, lastname, firstname, birthdate, phone, email, interests);
        } catch (UserAlreadyExistsException | LoginRulesException | PasswordRulesException e) {
            errorTextView.setText(e.toString());
            return;
        }

        AffichageFragment affichageFragment = new AffichageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("login", login);
        bundle.putString("password", password);
        //bundle.putString("lastname", lastname);
        //bundle.putString("firstname", firstname);
        //bundle.putString("birthdate", birthdate);
        //bundle.putString("phone", phone);
        //bundle.putString("email", email);
        //bundle.putString("interests", interests);
        affichageFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, affichageFragment).commit();

    }
}