package fr.eni.ludotheque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dall.ClientRepository;
import fr.eni.ludotheque.exceptions.ClientNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        
       
    }
    
    
    /*
     * Ajouter un client : 
     */
    

	@Override
	public void save(Client entity) {
		
		if(entity.getNoClient()==null) {
			this.add(entity); // Si le client n'a pas d'ID, on l'ajoute
			return;
		}
		this.update(entity);// Sinon, on met à jour le client
		
	}
    

    @Override
    public void add(Client client) {
        clientRepository.add(client);// Enregistrer un nouveau client
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();// Récupérer tous les clients
    }

    @Override
    public Optional<Client> getById(int id) {
        return clientRepository.getById(id);// Récupérer un client par son ID
    }

    public void update(Client client) {
    	 Optional<Client> clientOpt = getById(client.getNoClient());
         if (clientOpt.isPresent()) {
        	 clientRepository.update(client);	// Mettre à jour un client existant 
         }else {
        	 //TODO gerer l'erreur
        	 throw new ClientNotFoundException();// Erreur si le client n'existe pas
         }
        
    }

    public void delete(int id) {
        clientRepository.delete(id); // Supprimer un client
    }

}
