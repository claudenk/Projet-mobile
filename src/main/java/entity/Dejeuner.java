package entity;


import androidx.annotation.NonNull;

import java.util.List;
public class Dejeuner extends NoteDeFrais {



    private  User user;
    private  List<String> invites;
    private  String nomSociete;

    public Dejeuner(  List<String> invites, String nomSociete) {
        super(); // Appel du constructeur de la classe parente


        this.invites = invites;
        this.nomSociete = nomSociete;
    }

    public Dejeuner() {
        super();
    }


    public  String getInvites() {return invites.toString();
    }

    public  String getNomSociete() {return nomSociete;
    }


    @NonNull
    @Override


	public String toString() {
	
		String resultat = "" ;
		
		resultat += "\nListe d'inviter : " + invites ;
		resultat += "\nNom de la société: " + nomSociete ;

		
		return resultat ;
	}






    public void setInvites(String invites) {
    }

    public void setNomSociete(String nomSociete) {
    }

    public void setType(String type) {
    }

    public void setUser(String user) {
    }
}
