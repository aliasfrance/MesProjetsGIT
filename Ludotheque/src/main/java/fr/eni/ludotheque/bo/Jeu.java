package fr.eni.ludotheque.bo;

import java.util.List;
import java.util.Objects;

public class Jeu {
	
	private Integer noJeu;
	private String titre;
	private String reference;
	private String description;
	private Float tarifJournee;
	private int ageMin;
	private int duree;
	private List<Genre> genres;
	
		public Jeu(Integer noJeu, String titre, String reference, String description, Float tarifJournee, int ageMin,
			int duree, List<Genre> genres) {
		super();
		this.noJeu = noJeu;
		this.titre = titre;
		this.reference = reference;
		this.description = description;
		this.tarifJournee = tarifJournee;
		this.ageMin = ageMin;
		this.duree = duree;
		this.genres = genres;
	}
			
	public Integer getNoJeu() {
		return noJeu;
	}
	public void setNoJeu(Integer noJeu) {
		this.noJeu = noJeu;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getTarifJournee() {
		return tarifJournee;
	}
	public void setTarifJournee(Float tarifJournee) {
		this.tarifJournee = tarifJournee;
	}
	public int getAgeMin() {
		return ageMin;
	}
	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ageMin, description, duree, noJeu, reference, tarifJournee, titre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jeu other = (Jeu) obj;
		return ageMin == other.ageMin && Objects.equals(description, other.description) && duree == other.duree
				&& Objects.equals(noJeu, other.noJeu) && Objects.equals(reference, other.reference)
				&& Objects.equals(tarifJournee, other.tarifJournee) && Objects.equals(titre, other.titre);
	}
	@Override
	public String toString() {
		return "Jeu [noJeu=" + noJeu + ", titre=" + titre + ", reference=" + reference + ", description=" + description
				+ ", tarifJournee=" + tarifJournee + ", ageMin=" + ageMin + ", duree=" + duree + "]";
	}
	
	
	
}
	
	
	
	
	
	