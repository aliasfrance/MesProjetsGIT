package fr.eni.ludotheque.dall;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Jeu;

@Repository
public class JeuRepositoryJdbcImpl implements JeuRepository {


	//JDBC Template pour executer les requetes SQL
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public JeuRepositoryJdbcImpl(JdbcTemplate jdbcTemplace) {
		super();
		this.jdbcTemplate = jdbcTemplace;
	}

	/**
	 * Ajoute un jeu dans la base de données.
	 */
	public void add(Jeu ajouterUnJeu) {
		String sql = "INSERT INTO jeux (noJeu, titre,reference, description, tarifJournee, ageMin, duree)" +
				" VALUES (?,?,?,?,?,?,?)";
			
		jdbcTemplate.update(sql,
				ajouterUnJeu.getNoJeu(),
				ajouterUnJeu.getTitre(),
				ajouterUnJeu.getReference(),
				ajouterUnJeu.getDescription(),
				ajouterUnJeu.getTarifJournee(),
				ajouterUnJeu.getAgeMin(),
				ajouterUnJeu.getDuree());
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
	public void save(Jeu t) {
		// TODO Auto-generated method stub
		
	}

}
