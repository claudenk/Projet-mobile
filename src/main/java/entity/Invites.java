package entity;

import java.util.List;

public class Invites{
    private int id;
    private NoteDeFrais invites;

    public Invites(Integer id, List<NoteDeFrais> invites) {
        this.id = id;
        this.invites = (NoteDeFrais) invites;
    }

    public Invites() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NoteDeFrais> getInvites() {
        return (List<NoteDeFrais>) invites;
    }

    public void setInvites(List<NoteDeFrais> invites) {
        this.invites = (NoteDeFrais) invites;
    }
}
