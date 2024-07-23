package com.example.formationapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dao.InvitesDao;
import entity.Invites;

public class InvitesActivity extends AppCompatActivity {
    private EditText editTextId, editTextNoteDeFrais;
    public Button invitesButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invites);

        editTextId = findViewById(R.id.editTextId);
        editTextNoteDeFrais = findViewById(R.id.editTextNoteDeFrais);
        invitesButton = findViewById(R.id.invitesButton);

        invitesButton.setOnClickListener(v -> saveInvites());
    }

    private void saveInvites() {
        int id = Integer.parseInt(editTextId.getText().toString().trim());
        // Remarque : vous devez implémenter la logique pour obtenir les données de la note de frais
        // à partir des champs d'entrée EditText et les convertir en objet NoteDeFrais.

        // Validation des champs (à implémenter)

        // Créer un nouvel objet Invites
        Invites newInvites = new Invites();
        newInvites.setId(id);
        // Assurez-vous d'implémenter la logique pour obtenir les données de la note de frais
        // et de les définir dans newInvites.

        // Enregistrer le nouvel objet Invites dans la base de données
        InvitesDao.saveInvites(newInvites);

        // Affichage d'un message de succès
        Toast.makeText(this, "Invités enregistrés avec succès", Toast.LENGTH_SHORT).show();

        // Redirection vers MainActivity
        Intent intent = new Intent(InvitesActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Termine l'activité InvitesActivity pour empêcher l'utilisateur de revenir à cette activité en appuyant sur le bouton retour
    }

    public EditText getEditTextNoteDeFrais() {
        return editTextNoteDeFrais;
    }

    public void setEditTextNoteDeFrais(EditText editTextNoteDeFrais) {
        this.editTextNoteDeFrais = editTextNoteDeFrais;
    }
}