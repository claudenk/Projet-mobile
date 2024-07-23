package com.example.formationapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DejeunerDao;
import entity.Dejeuner;
import entity.User;

public class DejeunerActivity extends AppCompatActivity {
    private EditText editTextDate, editTextMontant,  editTextNomSociete, editTextInvites;
    private Button dejeunerbutton;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dejeuner);

        editTextDate = findViewById(R.id.editTextDate);
        editTextMontant = findViewById(R.id.editTextMontant);

        editTextNomSociete = findViewById(R.id.editTextNomSociete);
        editTextInvites = findViewById(R.id.editTextInvites);
        dejeunerbutton = findViewById(R.id.dejeunerButton);

        dejeunerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { registerDejeuner();

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void registerDejeuner() {
        // Récupérer les valeurs des champs
        LocalDate date = LocalDate.parse(editTextDate.getText().toString().trim());
        double montant = Double.parseDouble(editTextMontant.getText().toString().trim());
         // Assurez-vous que le texte correspond à une valeur de l'énumération Type
        String nomSociete = editTextNomSociete.getText().toString().trim();
        String invitesText = editTextInvites.getText().toString().trim();
        List<String> invites = convertStringToList(invitesText);

        // Créer un nouvel objet Dejeuner
        Dejeuner newDejeuner = new Dejeuner();
        newDejeuner.setType("Dejeuner");

        // Enregistrer le nouvel objet Dejeuner dans la base de données
        DejeunerDao.saveDejeuner(newDejeuner);

        // Afficher un message de succès
        Toast.makeText(this, "Déjeuner enregistré avec succès", Toast.LENGTH_SHORT).show();

        // Redirection vers une autre activité
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Terminer l'activité DejeunerActivity pour empêcher l'utilisateur de revenir en arrière
    }

    public User getUser() {

        return new User();
    }

    private List<String> convertStringToList(String invitesText) {

        return new ArrayList<>();
    }
}