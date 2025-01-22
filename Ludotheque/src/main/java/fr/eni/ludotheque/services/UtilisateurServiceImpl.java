package fr.eni.ludotheque.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.dall.GestionUtilisateurRepositoryImpl;
import fr.eni.ludotheque.security.GestionUtilisateurDetailsServicImpl;

/**
 * Implémentation de la gestion des utilisateurs.
 */


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	
	private final GestionUtilisateurRepositoryImpl gestionUtilisateurRepositoryImpl;
		
	public UtilisateurServiceImpl(GestionUtilisateurRepositoryImpl gestionUtilisateurRepositoryImpl) {
				this.gestionUtilisateurRepositoryImpl = gestionUtilisateurRepositoryImpl;
	}

	@Override
	public Optional<Utilisateur> recupereUtilisateurParEmail(String email) {
		// TODO Auto-generated method stub
		return gestionUtilisateurRepositoryImpl.FindByEmail(email);
	}
	
	
	
}
