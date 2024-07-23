package entity;

import java.time.LocalDate;



public abstract class NoteDeFrais {
	private int id;
	private LocalDate date;
	private double montant;
	private String details ;
	private Type type;


	public NoteDeFrais() {


	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getMontant() {
		return montant;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}



	public String getDetails() {
		return details;
	}
}
