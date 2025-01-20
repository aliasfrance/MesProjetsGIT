package fr.eni.ludotheque.dall;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Client;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
	
	//JdbcTemplate pour exécuter les requêtes SQL
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
    * Ajoute un nouveau client dans la base de données.
    */
	@Override
	public void add(Client ajouterClient) {
	    // Requête SQL pour insérer un client dans la base de données "table"
	    String sql = "INSERT INTO client (nom, prenom, email, noTelephone, rue, codePostal, ville) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    // Exécuter l'insertion
	    jdbcTemplate.update(sql,
	        ajouterClient.getNom(),
	        ajouterClient.getPrenom(),
	        ajouterClient.getEmail(),
	        ajouterClient.getNoTelephone(),
	        ajouterClient.getRue(),
	        ajouterClient.getCodePostal(),
	        ajouterClient.getVille()
	    );
	}

	/**
     * Récupère tous les clients de la base de données.
     * Retourne une liste de tous les clients
     */
    @Override
    public List<Client> getAll() {
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, new ClientRowMapper());
    }

    /**
     * Récupère un client par son identifiant.
     *
     * @param id L'identifiant du client à récupérer.
     * @return Un objet Optional contenant le client s'il est trouvé.
     */
    @Override
    public Optional<Client> getById(int id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        List<Client> clients = jdbcTemplate.query(sql, new ClientRowMapper(), id);
        return clients.stream().findFirst();
    }
    
    
    
    /**
     * Met à jour les informations d'un client existant.
     *
     * @param unClient Le client avec les nouvelles informations.
     */
    @Override
    public void update(Client unClient) {
        String sql = "UPDATE client SET nom = ?, prenom = ?, email = ?, noTelephone = ?, rue = ?, codePostal = ?, ville = ? WHERE id = ?";
        jdbcTemplate.update(sql,
            unClient.getNom(),
            unClient.getPrenom(),
            unClient.getEmail(),
            unClient.getNoTelephone(),
            unClient.getRue(),
            unClient.getCodePostal(),
            unClient.getVille(),
            unClient.getNoClient()
        );
    }
    
    /**
     * Supprime un client de la base de données par son identifiant.
     *
     * @param id L'identifiant du client à supprimer.
     */
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM client WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void save(Client unClient) {
        if (unClient.getNoClient() == null) {
            // Ajouter un nouveau client
            String sql = "INSERT INTO client (nom, prenom, email, noTelephone, rue, codePostal, ville) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                var ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, unClient.getNom());
                ps.setString(2, unClient.getPrenom());
                ps.setString(3, unClient.getEmail());
                ps.setString(4, unClient.getNoTelephone());
                ps.setString(5, unClient.getRue());
                ps.setString(6, unClient.getCodePostal());
                ps.setString(7, unClient.getVille());
                return ps;
            }, keyHolder);
            unClient.setNoClient(keyHolder.getKey().intValue());
        } else {
            // Mise à jour d'un client existant
            update(unClient);
        }
    }
	
    
    
    /**
    * Classe interne pour mapper les résultats SQL vers des objets Client.
    * mappe la base de données  des clients (toutes les colonnes) trouvés et renvoie un objet Java dans Eclipse 
	* => de la base vers JAVA
	*/
	
    class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setNoClient(rs.getInt("id")); // Mapping de l'identifiant
            client.setNom(rs.getString("nom")); // Mapping du nom
            client.setPrenom(rs.getString("prenom")); // Mapping du prénom
            client.setEmail(rs.getString("email")); // Mapping de l'email
            client.setNoTelephone(rs.getString("noTelephone")); // Mapping du numéro de téléphone
            client.setRue(rs.getString("rue")); // Mapping de la rue
            client.setCodePostal(rs.getString("codePostal")); // Mapping du code postal
            client.setVille(rs.getString("ville")); // Mapping de la ville
            return client;
		}
	}

}
