package fr.eni.ludotheque.dall;


import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Client;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static int idxClient = 1;
    private List<Client> clients;
    
    	
	/*
	créatioin client en local (plus besoin)
		public ClientRepositoryImpl() {
        clients = new ArrayList<>();
        clients.add(new Client(idxClient++, "Hanks", "Tom", "tom.hanks@email.com", "123-456-7890", "34 Forrest Avenue", "90210", "Los Angeles"));
        clients.add(new Client(idxClient++, "Streep", "Meryl", "meryl.streep@email.com", "234-567-8901", "15 Devil Wears Prada Street", "10001", "New York"));
        clients.add(new Client(idxClient++, "DiCaprio", "Leonardo", "leo.dicaprio@email.com", "345-678-9012", "23 Titanic Boulevard", "33139", "Miami"));
        clients.add(new Client(idxClient++, "Roberts", "Julia", "julia.roberts@email.com", "456-789-0123", "17 Pretty Woman Lane", "90077", "Beverly Hills"));
        clients.add(new Client(idxClient++, "Washington", "Denzel", "denzel.washington@email.com", "567-890-1234", "7 Training Day Road", "20001", "Washington D.C."));
    }*/
    
    @Override
    public void add(Client client) {
        idxClient++;
        client.setNoClient(idxClient);
        System.out.println(client);
        this.client.add(client);
    }

    
    
    @Autowired
    private JDBCType jdbcTemplate; // Injection de JdbcTemplate
    
    
    public ClientRepositoryImpl( JDBCType jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
	
	
	

   
    @Override
    public List<Client> getAll() {
    	String sql = "select * from client";
    	
    	List<Client> clients = jdbcTemplate.query(sql, new ClientRowMapper()):
    		
    		return clients;
    		
    }
       
    

    @Override
    public  Optional<Client> getById(int id) {
        return this.clients.stream().filter(c ->  c.getNoClient() == id).findFirst();
    }

    public void update(Client client) {
        Optional<Client> oldClientOptional = getById(client.getNoClient());
        if (oldClientOptional.isPresent()) {
        	
            Client oldClient = oldClientOptional.get();
            BeanUtils.copyProperties(client, oldClient);
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

    public void delete(int id) {
        Optional<Client> clientOptional = getById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
           clients.remove(client);
        }
    }
    
// AJOUTER UN CLIENT DANS LA BASE DE DONNEE 
@Override
public void save(Client client) {
	if(client.getNom()==null) {
		// AJOUTER UN NOUVEAU CLIENT
		String sql = "insert into client (id, nom, prenom, email, noTelephone, rue, codePostal, ville) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
	
		jdbcTemplate.update(sql, client.getNoClient(), client.getNom(), client.getPrenom(), client.getEmail(), client.getNoTelephone(),
                client.getRue(), client.getCodePostal(), client.getVille());
		
		
		
		// Récupération de la clé primaire générée
        Integer clePrimaireGeneree = keyHolder.getKey().intValue();
        client.setNoClient(clePrimaireGeneree); // Mettre à jour l'objet client avec l'ID généré
		
	}else {
		  // Modification d'un client existant
        String sql = "UPDATE client SET nom = ?, prenom = ?, email = ?, noTelephone = ?, rue = ?, codePostal = ?, ville = ? WHERE noClient = ?";
	}
}
//KeyHolder keyHolder = new GeneratedKeyHolder(); //récupérer la clef primaire générer par la base de donnée
    
    
}
