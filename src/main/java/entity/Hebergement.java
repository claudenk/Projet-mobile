package entity;

import androidx.annotation.NonNull;

import java.time.LocalDate;

public class Hebergement extends NoteDeFrais {

   private LocalDate date;
    private int distance;






    public Hebergement(LocalDate date, double montant, int distance, Type type, entity.User user) {
        super();
        this.distance = distance;

        this.date=date;
    }

    public Hebergement() {
        super();
    }


    // Getters et setters`
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }

    @NonNull
    @Override
    public String toString() {

        String resultat = "" ;

        resultat += "\nVille : " + distance ;

        return resultat ;
    }



    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
