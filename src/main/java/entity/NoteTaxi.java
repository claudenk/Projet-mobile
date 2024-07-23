package entity;

import androidx.annotation.NonNull;

public class NoteTaxi extends NoteDeFrais {

    private String villeDepart;
    private String villeArrivee;




    public NoteTaxi() {
        super();



    }



    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }



    @NonNull
    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nVille de départ : " + villeDepart ;
        resultat += "\nVille d'arrivée : " + villeArrivee ;

        return resultat ;
    }


}

