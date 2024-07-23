package entity;

public class Type {

    private int id;
    private String Libelle;

    public Type(int id, String libelle) {
        this.id = id;
        Libelle = libelle;
    }
    public Type(){}

    public static Type valueOf(String type) {
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }
}
