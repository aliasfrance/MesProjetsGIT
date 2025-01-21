package fr.eni.ludotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    // Page de connexion personnalisée
    @GetMapping("/login")
    public String login() {
        return "login"; // Assurez-vous que le fichier login.html existe dans le répertoire templates
    }

    // Page d'accueil après connexion réussie
    @RequestMapping("/home")
    public String home() {
        return "home"; // Assurez-vous que le fichier home.html existe dans le répertoire templates
    }
}
