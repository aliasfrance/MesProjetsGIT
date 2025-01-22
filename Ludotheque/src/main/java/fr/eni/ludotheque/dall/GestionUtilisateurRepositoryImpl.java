package fr.eni.ludotheque.dall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.security.GestionUtilisateurDetailsServicImpl;

@Repository
public class GestionUtilisateurRepositoryImpl implements GestionUtilisateurRepository{
	
	private JdbcTemplate jdbcTemplate;

		
	public GestionUtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate){
		
		this.jdbcTemplate = jdbcTemplate;
	}
	
	------------------------A FINIR ----------------------------------------

	public Optional<Utilisateur> FindByEmail (String email){
		// Requete SQL pour récupère dans la BD le profil utilisateur
		String sql = "SELECT * FROM utilisateurs where email = ?";
		 // Exécuter l'insertion
	    Utilisateur utilisateur = jdbcTemplate.update(sql,new UtilisateurRowmapper,email);
		
		
		return utilisateur ;
		

		
	}
	 /**
	    * Classe interne pour mapper les résultats SQL vers des objets Utilisateur.
	    * mappe la base de donnée  des utilisateurs (toutes les colonnes) trouvés et renvoie un objet Java dans Eclipse 
		* => de la BD vers JAVA
		*/
		
	    class UtisateurRowMapper implements RowMapper<Utilisateur> {
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

	
	
	
	
	
	@Override
	public Optional<GestionUtilisateurDetailsServicImpl> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	};
	
	
	


}


	
	
	