package com.example.formationapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import dao.UserDao;
import entity.User;





public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    protected Button loginButton;
    protected Button buttonRegister;
   protected Button  dejeunerButton;
   protected Button hebergementButton;
   protected Button invitesButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        buttonRegister = findViewById(R.id.buttonRegisterM);
        dejeunerButton= findViewById(R.id.dejeunerButton);
        hebergementButton= findViewById(R.id.hebergementButton);
        invitesButton= findViewById(R.id.invitesButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }

        });

        dejeunerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DejeunerActivity.class);
                startActivity(intent);
                finish();
            }


        });
        hebergementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HebergementActivity.class);
                startActivity(intent);
                finish();
            }


        });
        invitesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InvitesActivity.class);
                startActivity(intent);
                finish();
            }


        });





    }

    private void login() {
        String email = emailEditText.getText().toString().trim();
        //Utilisez trim( pour supprimer les espaces avant et apres.
        String password = passwordEditText.getText().toString().trim();

        //Vérifier si les champs ne sont pas vides
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir les champs.", Toast.LENGTH_SHORT).show();
            return; //Arretez la methode ici si les les champs sont vides
        }
        //
        User user = UserDao.findUserByEmailAndPassword(email, password);
        if (user != null) {
            //l'utilisateur existe, redirection vers une autre activité
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Termine MainActivity pour empêcher le retour à l'écran de connexion
        } else {
            Toast.makeText(this, "Informations d'identification invalides.", Toast.LENGTH_SHORT).show();

        }
    }
}





