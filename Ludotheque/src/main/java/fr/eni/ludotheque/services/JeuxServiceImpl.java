package fr.eni.ludotheque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Jeu;

@Service
public class JeuxServiceImpl implements JeuxService {

	
	private JeuxRepository jeuRepository;
	
	
	
	
	
	
	// ajouter un jeu
	
	public void add(jeu MonJeu)
		jeuRepo(MonJeu);
		
		
		
	// afficher la liste des jeux
	// afficher un jeu
	// ajouter un exemplaire
	//modifier un exemplaire
	//Afficher les exemplaires de jeu sur la page détail du jeu
	//Mettre l'insert d'un jeu et ses genres sous forme de procédure stockée !!
	
	
	
}

	@Override
	public void add(Jeu entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Jeu> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Jeu> getById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Jeu entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Jeu entity) {
		// TODO Auto-generated method stub
		
	}
