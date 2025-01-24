package fr.eni.ludotheque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dall.JeuRepository;

@Service
public class JeuServiceImpl<GenreRepository> implements JeuService {
	
	private JeuRepository jeuRepo;
	//private GenreRepository genreRepo;
	
	public JeuServiceImpl (JeuRepository jeuRepo) {
		this.jeuRepo = jeuRepo;
		//this.genreRepo = genreRepo;
	}
	
	  /**
     * Ajouter un jeu en l'enregistrant dans la base de données.
     *
     * @param jeu l'objet Jeu à ajouter
     */
    @Override
    public void add(Jeu jeu) {
        jeuRepo.add(jeu); // Appelle le repository pour sauvegarder l'objet
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

}

	
	
	// afficher la liste des jeux
		// afficher un jeu
		// ajouter un exemplaire
		//modifier un exemplaire
		//Afficher les exemplaires de jeu sur la page détail du jeu
		//Mettre l'insert d'un jeu et ses genres sous forme de procédure stockée !!
		