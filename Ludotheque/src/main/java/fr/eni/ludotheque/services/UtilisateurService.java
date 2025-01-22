package fr.eni.ludotheque.services;

import java.util.Optional;

import fr.eni.ludotheque.bo.Utilisateur;


/**
 * Interface pour la gestion des utilisateurs.
 */

public interface UtilisateurService {
	
	public Optional<Utilisateur> recupereUtilisateurParEmail(String email);
	
	
	


	

}
