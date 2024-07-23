package com.example.formationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formationapp.R;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import entity.User;
import entity.UserAdapter;

public class ListUserActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    private List<User> userList;
    public static final int EDIT_USER_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_user);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialiser la liste des utilisateurs (cela pourrait venir d'une base de données)
        userList = new ArrayList<>();
        userList = UserDao.findAllUsers();
        Intent intent= getIntent() ;

        userAdapter = new UserAdapter(userList, this,editUserActivityResultLauncher);

        recyclerView.setAdapter(userAdapter);
    }

    private final ActivityResultLauncher<Intent>
            editUserActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // Le code ici sera exécuté si le résultat de EditUserActivity est RESULT_OK
                    // Par exemple, recharger les données de l'utilisateur et mettre à jour le RecyclerView
                    reloadUserData();
                }
            });

    private void reloadUserData() {

        List<User> updatedUserList = UserDao.findAllUsers();

        userAdapter.setUserList(updatedUserList);
        userAdapter.notifyDataSetChanged();

    }

}