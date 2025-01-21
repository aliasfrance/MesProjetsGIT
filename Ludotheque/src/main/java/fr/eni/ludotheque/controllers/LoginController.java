package fr.eni.ludotheque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    // Page de connexion personnalisée
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

    // Page d'accueil après connexion réussie
    @RequestMapping("/accueil")
    public String accueil() {
        return "accueil"; 
    }
}
