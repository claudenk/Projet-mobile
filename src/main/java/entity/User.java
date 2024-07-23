package entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
    private NoteDeFrais noteDeFrais;

    public User(int id, String nom, String prenom, String email, String password, Role role, NoteDeFrais noteDeFrais) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {

    }


    //ajoutez les getters et les setters
    public int getId() {
    return id;
}
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String nom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public NoteDeFrais getNoteDeFrais() {
        return noteDeFrais;
    }

    public void setNoteDeFrais(NoteDeFrais noteDeFrais) {
        this.noteDeFrais = noteDeFrais;
    }
}
