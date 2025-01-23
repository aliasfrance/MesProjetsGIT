package fr.eni.ludotheque.bo;

import java.util.Objects;

public class Utilisateur {

	private Integer noUtilisateur;
	private String email;
	private String motDePasse;
	private String roles;


	public Utilisateur() {
		super();
	}

	public Utilisateur(Integer noUtilisateur, String email, String motDePasse, String roles) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.email = email;
		this.motDePasse = motDePasse;
		this.roles = roles;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, motDePasse, noUtilisateur, roles);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(email, other.email) && Objects.equals(motDePasse, other.motDePasse)
				&& Objects.equals(noUtilisateur, other.noUtilisateur) && Objects.equals(roles, other.roles);
	}


	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse
				+ ", roles=" + roles + "]";
	}
}
