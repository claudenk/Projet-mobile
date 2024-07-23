package com.example.formationapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

import dao.HebergementDao;
import entity.Hebergement;
import entity.Type;
import entity.User;

public class HebergementActivity extends AppCompatActivity {
    private EditText editTextDate, editTextMontant, editTextDistance, editTextType;
    private Button hebergementButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hebergement);

        editTextDate = findViewById(R.id.editTextDate);
        editTextMontant = findViewById(R.id.editTextMontant);
        editTextDistance = findViewById(R.id.editTextDistance);
        editTextType = findViewById(R.id.editTextType);
        hebergementButton = findViewById(R.id.hebergementButton);

        hebergementButton.setOnClickListener(v -> registerHebergement());
    }

    private void registerHebergement() {
        // Récupérer les valeurs des champs
        LocalDate date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date = LocalDate.parse(editTextDate.getText().toString().trim());
        }
        double montant = Double.parseDouble(editTextMontant.getText().toString().trim());
        int distance = Integer.parseInt(editTextDistance.getText().toString().trim());
        Type type = Type.valueOf(editTextType.getText().toString().trim()); // Assurez-vous que le texte correspond à une valeur de l'énumération Type

        // Créer un nouvel objet Hebergement
        Hebergement newHebergement = new Hebergement(date, montant, distance, type, getUser());

        // Enregistrer le nouvel objet Hebergement dans la base de données
        HebergementDao.saveHebergement(newHebergement);

        // Afficher un message de succès
        Toast.makeText(this, "Hébergement enregistré avec succès", Toast.LENGTH_SHORT).show();

        // Redirection vers une autre activité
        Intent intent = new Intent(HebergementActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Terminer l'activité HebergementActivity pour empêcher l'utilisateur de revenir en arrière
    }

    private User getUser() {
        return new User();
    }
}