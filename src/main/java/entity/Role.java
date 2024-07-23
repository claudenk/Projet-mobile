package entity;

import java.io.Serializable;

public class Role implements Serializable {
    private int id;
    private String roleName;
// ajouetez les getters et les Setters

    public int getId() {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getroleName() {
        return roleName;
    }
    public void setroleName(String roleName) {
        this.roleName= roleName;
    }
}
