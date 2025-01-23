package fr.eni.ludotheque.bo;

import java.util.Objects;

public class Genre {

	private Integer noGenre;
	private String libelle;


	public Genre (Integer noGenre, String libelle) {
		this.noGenre = noGenre;
		this.libelle = libelle;
	}


	public Integer getNoGenre() {
		return noGenre;
	}


	public void setNoGenre(Integer noGenre) {
		this.noGenre = noGenre;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public int hashCode() {
		return Objects.hash(libelle, noGenre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(libelle, other.libelle) && Objects.equals(noGenre, other.noGenre);
	}


	@Override
	public String toString() {
		return "Genre [noGenre=" + noGenre + ", libelle=" + libelle + "]";
	}




}




