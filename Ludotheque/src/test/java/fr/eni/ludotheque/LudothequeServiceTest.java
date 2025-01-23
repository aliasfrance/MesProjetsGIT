package fr.eni.ludotheque;

import java.util.Optional;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.dall.ClientRepository;



@SpringBootTest
public class LudothequeServiceTest {
	
	
	@MockBean
	private ClientRepository clientRepository;

	@Test
	//Arange
	void recupereUtilisateurParEmail();
	int findById = email;
	
	//Act
	
	//Assert
	
	
	
    public LudothequeServiceTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    
    public Optional <Utilisateur> recupereUtilisateurParEmail(String email);
        
        
}
