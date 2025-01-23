package fr.eni.ludotheque.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.security.GestionUtilisateurDetailsServicImpl;
import fr.eni.ludotheque.services.UtilisateurService;


@Service
public class GestionUtilisateurDetailsServicImpl implements UserDetailsService {

	@Autowired	
	private UtilisateurService utilisateurService;
	
	
	@Override
	/*
	 * Est appelée à chaque connexion utilisateur username : login saisi par
	 * l'utilisateur
	 */
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Utilisateur> utilisateurOptionnel = utilisateurService.recupereUtilisateurParEmail(email);

		System.out.println(utilisateurOptionnel.get());
		UserDetails user = null;

		if (utilisateurOptionnel.isPresent()) {
			Utilisateur utilisateur1 = utilisateurOptionnel.get();
			user = User.builder()
					.username(email)
					.password(utilisateur1.getMotDePasse()) 
					.roles(utilisateur1.getRoles())
					.build();
			
			return user;
		}
		throw new UsernameNotFoundException(email + " introuvable.");
	}

}

