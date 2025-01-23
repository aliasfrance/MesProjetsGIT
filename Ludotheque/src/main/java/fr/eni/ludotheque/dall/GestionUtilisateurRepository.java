package fr.eni.ludotheque.dall;

import java.util.Optional;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.security.GestionUtilisateurDetailsServicImpl;

/**
 * Dépôt pour accéder aux données des utilisateurs.
 */


public interface GestionUtilisateurRepository {

		public Optional <Utilisateur> recupereUtilisateurParEmail(String email);
	
	
	

	
	
	
}
