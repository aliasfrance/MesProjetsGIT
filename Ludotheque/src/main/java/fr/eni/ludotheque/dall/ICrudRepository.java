package fr.eni.ludotheque.dall;


import fr.eni.ludotheque.bo.Client;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T> {
    void add(T entity);

    public List<T> getAll();

    Optional<T> getById(int id);

    void update(T entity);

    void delete(int id);
    
    //Ajouter un client dans la base de donnée ou modifier si le client a déjà un id
	void save(Client client);

	List<Client> findAll();
}
