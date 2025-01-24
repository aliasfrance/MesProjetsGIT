package fr.eni.ludotheque.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.services.JeuService;


@Controller
@RequestMapping("/jeux")
public class JeuxController {

	//Injection de dépendance du jeu service
	private JeuService jeuService;

	// Injection du service via le constructeur
	public JeuxController (JeuService jeuService) {
		this.jeuService = jeuService;
	}

	/**
	 * Préparer un formulaire pour ajouter un jeu : 
	 * Prépare le modèle pour afficher un formulaire permettant d'ajouter un nouveau jeu.
	 * Ajoute un objet Jeu vide au modèle, prêt à être rempli via un formulaire.
	 *
	 * @param model le modèle utilisé pour transmettre des données à la vue
	 * @return le nom de la vue "jeux/ajouter" où le formulaire sera affiché
	 */
	@GetMapping("/ajouter")
	public String ajouterUnjeu(Model model) {
		model.addAttribute("jeu", new Jeu()); // Prépare un objet vide pour le formulaire
		return "jeux/ajouter"; // Retourne la vue pour le formulaire d'ajout
	}
	/*
     * Afficher la liste des jeux 
     */
    @GetMapping()
    public String jeux(Model model) {
        List<Jeu> clients = jeuService.getAll();
        model.addAttribute("clients", clients);
        model.addAttribute("body", "pages/jeux/jeux");
        return "index";
    }
	
}