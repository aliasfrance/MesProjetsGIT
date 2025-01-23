package fr.eni.ludotheque.dall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.security.GestionUtilisateurDetailsServicImpl;

@Repository
public class GestionUtilisateurRepositoryImpl implements GestionUtilisateurRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public GestionUtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate){

		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Optional<Utilisateur> recupereUtilisateurParEmail(String email) {

		//Requête SQL pour récupérer l'email de  l'utilisateur.
		String sql = "SELECT * FROM utilisateurs where email = ?";

		// Exécuter la requête et mapper le résultat  pour convertir chaque ligne de résultat en un objet Utilisateur.

		return jdbcTemplate.query(sql, new UtilisateurRowMapper(), email)
				.stream() // Convertir le résultat en Stream
				.findFirst(); // Récupérer le premier élément (ou aucun)
	}


}


/**
 * Mapper pour convertir les lignes du résultat SQL en objets Utilisateur.
 * 
 */
class UtilisateurRowMapper implements RowMapper<Utilisateur> {
	@Override
	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur")); // Mapping dans la base de donnee utilisateur
		utilisateur.setEmail(rs.getString("email")); //  Mapping dans la base de donnee utilisateur
		utilisateur.setMotDePasse(rs.getString("mot_de_passe")); //  Mapping dans la base de donnee utilisateur
		utilisateur.setRoles(rs.getString("role")); //  Mapping dans la base de donnee utilisateur

		return utilisateur;
	}
}







