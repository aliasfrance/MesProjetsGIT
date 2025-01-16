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


	private static int idxClient = 1;
	private List<Client> clients;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(Client unClient) {
		idxClient++;
		unClient.setNoClient(idxClient);
		System.out.println(unClient);
		this.clients.add(unClient);
		
	}

	@Override
	public List<Client> getAll() {
		String sql = "select * from client";

		List<Client> clients = jdbcTemplate.query(sql, new ClientRowMapper());

		return clients;
	}

	@Override
	public Optional<Client> getById(int id) {
		return this.clients.stream().filter(c ->  c.getNoClient() == id).findFirst();
	}

	@Override
	public void update(Client unClient) {
		Optional<Client> oldClientOptional = getById(unClient.getNoClient());
		if (oldClientOptional.isPresent()) {

			Client oldClient = oldClientOptional.get();
			BeanUtils.copyProperties(unClient, oldClient);
			/*
        oldClient.setNom(client.getNom());
        oldClient.setPrenom(client.getPrenom());
        oldClient.setRue(client.getRue());
        oldClient.setCodePostal(client.getCodePostal());
        oldClient.setVille(client.getVille());
        oldClient.setEmail(client.getEmail());
        oldClient.setNoTelephone(client.getNoTelephone());
			 */
		}		
	}

	@Override
	public void delete(int id) {
		Optional<Client> clientOptional = getById(id);
		if (clientOptional.isPresent()) {
			Client client = clientOptional.get();
			clients.remove(client);
		}
	}

	@Override
	public void save(Client unClient) {
		if(unClient.getNom()==null) {
			// AJOUTER UN NOUVEAU CLIENT
			String sql = "insert into client (id, nom, prenom, email, noTelephone, rue, codePostal, ville) values (?, ?, ?, ?, ?, ?, ?, ?)";


			jdbcTemplate.update(sql, unClient.getNoClient(), unClient.getNom(), unClient.getPrenom(), unClient.getEmail(), unClient.getNoTelephone(),
					unClient.getRue(), unClient.getCodePostal(), unClient.getVille());


			KeyHolder keyHolder = new GeneratedKeyHolder();
			// Récupération de la clé primaire générée
			Integer clePrimaireGeneree = keyHolder.getKey().intValue();
			unClient.setNoClient(clePrimaireGeneree); // Mettre à jour l'objet client avec l'ID généré

		}else {
			// Modification d'un client existant
			String sql = "UPDATE client SET nom = ?, prenom = ?, email = ?, noTelephone = ?, rue = ?, codePostal = ?, ville = ? WHERE noClient = ?";
		}
		
	}
	
	class ClientRowMapper implements RowMapper<Client>{

		@Override
		public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
			Client client = new Client();
			//Mapping colonnes requetes vers instance java
			//mappe la base de données des clients trouvés et renvoie un objet dans Eclipse
			client.setNoClient(rs.getInt("id"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setEmail(rs.getString("email"));
			client.setNoTelephone(rs.getString("noTelephone"));
			client.setRue(rs.getString("rue"));
			client.setCodePostal(rs.getString("codePostal"));
			client.setVille(rs.getString("ville"));

			return client;
		}
	}

}
