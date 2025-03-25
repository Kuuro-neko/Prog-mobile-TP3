package com.example.prog_mobile_tp3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AffichageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AffichageFragment extends Fragment {
    DatabaseHelper databaseHelper;
    private TextView textViewLogin;
    private TextView textViewPassword;
    private TextView textViewLastname;
    private TextView textViewFirstname;
    private TextView textViewBirthdate;
    private TextView textViewPhone;
    private TextView textViewEmail;
    private TextView textViewInterests;
    private Button returnButton;

    public AffichageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_affichage, container, false);
        databaseHelper = new DatabaseHelper(getContext());

        textViewLogin = view.findViewById(R.id.login);
        textViewPassword = view.findViewById(R.id.password);
        textViewLastname = view.findViewById(R.id.lastname);
        textViewFirstname = view.findViewById(R.id.firstname);
        textViewBirthdate = view.findViewById(R.id.birthdate);
        textViewPhone = view.findViewById(R.id.phone);
        textViewEmail = view.findViewById(R.id.email);
        textViewInterests = view.findViewById(R.id.interests);
        returnButton = view.findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InscriptionFragment inscriptionFragment = new InscriptionFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, inscriptionFragment).commit();
            }
        });

        Bundle bundle = getArguments();

        if (bundle != null) {
            String login = bundle.getString("login");
            String password = bundle.getString("password");

            User user = databaseHelper.getUser(login, password);
            textViewLogin.setText(login);
            textViewPassword.setText(password);
            textViewLastname.setText(user.getLastname());
            textViewFirstname.setText(user.getFirstname());
            textViewBirthdate.setText(user.getBirthdate());
            textViewPhone.setText(user.getPhone());
            textViewEmail.setText(user.getEmail());
            textViewInterests.setText(user.getInterests());
        }

        return view;
    }
}