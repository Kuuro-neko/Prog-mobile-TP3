package com.example.prog_mobile_tp3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InscriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InscriptionFragment extends Fragment {
    private EditText editTextLogin;
    private EditText editTextPassword;
    private EditText editTextLastname;
    private EditText editTextFirstname;
    private EditText editTextBirthdate;
    private EditText editTextPhone;
    private EditText editTextEmail;
    private EditText editTextInterests;
    private Button submitButton;

    OnInscriptionListener callback;

    public interface OnInscriptionListener {
        void onInscriptionListener(
                String login,
                String password,
                String lastname,
                String firstname,
                String birthdate,
                String phone,
                String email,
                String interests
        );
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (OnInscriptionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnInscriptionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inscription, container, false);

        editTextLogin = view.findViewById(R.id.login);
        editTextPassword = view.findViewById(R.id.password);
        editTextLastname = view.findViewById(R.id.lastname);
        editTextFirstname = view.findViewById(R.id.firstname);
        editTextBirthdate = view.findViewById(R.id.birthdate);
        editTextPhone = view.findViewById(R.id.phone);
        editTextEmail = view.findViewById(R.id.email);
        editTextInterests = view.findViewById(R.id.interests);
        submitButton = view.findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();
                String lastname = editTextLastname.getText().toString();
                String firstname = editTextFirstname.getText().toString();
                String birthdate = editTextBirthdate.getText().toString();
                String phone = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                String interests = editTextInterests.getText().toString();

                callback.onInscriptionListener(login, password, lastname, firstname, birthdate, phone, email, interests);
            }
        });

        return view;
    }
}