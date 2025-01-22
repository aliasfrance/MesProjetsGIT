package fr.eni.ludotheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class ClientSecurityConfig {
	
	
	//1.  Dépendance : spring-boot-starter-security : Configure PAR DEFAULT l'authentification et la sécurité de base. 
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/accueil").permitAll()// Permet l'accès sans authentification aux URLs spécifiées
				
				//.requestMatchers( "/prive").permitAll("USER")
				//.requestMatchers( "/prive").hasAnysAuthority("ROLES_USER", "PERMISSION2")
				
				.anyRequest().authenticated()//Toute autre requête nécessite une authentification
			)
			//Pour s'authentifer nous on le mettrai dans le controller
			.formLogin((form) -> form
				.loginPage("/login")//  page de connexion personnalisée
				.permitAll()
				.defaultSuccessUrl("/accueil", true) // Redirige vers la page d'accueil après la connexion réussie
			)
			.logout((logout) -> logout.permitAll());// Permet à tous de se déconnecter

		return http.build();
	}

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(); // Encodeur pour gérer les mots de passe sécurisés
	    }
	 
	 
	 
	 
	 
	 //CLASSE DE REMPLACEMENT : GestionUtilisateurDetailsServiceImpl.java
	// Création d'un utilisateur en mémoire (inMemory)
	 

	/* 1- changer le @Bean pour le mettre en @Component
	 * 2- créer sa classe 
	 * 3- créer la base de données, puis le récupérer sur la base de donné
 @Bean
	 public UserDetailsService userDetailsService() {
	 var user1 = User.withUsername("zozo")
             .password(passwordEncoder().encode("password"))
             .roles("USER") // Rôle USER pour l'utilisateur zozo
             .build();
             
             
	 var user2 = User.withUsername("admin")
             .password(passwordEncoder().encode("password"))
             .roles("ADMIN") // Rôle ADMIN pour l'utilisateur admin
             .build();
	 
	 
	 
	 return new InMemoryUserDetailsManager(user1, user2); // Ajout des deux utilisateurs
 }


*/





}
	
	