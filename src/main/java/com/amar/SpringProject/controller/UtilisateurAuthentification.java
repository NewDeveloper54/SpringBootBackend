package com.amar.SpringProject.controller;


import com.amar.SpringProject.model.Utilisateur;
import com.amar.SpringProject.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/auth")

public class UtilisateurAuthentification {

    @Autowired
    private UtilisateurService utilisateurService;

    // POST pour inscription
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> existingUser = utilisateurService.trouverParEmail(utilisateur.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Cet email est déjà utilisé.");
        }
        Utilisateur savedUser = utilisateurService.inscrire(utilisateur);
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint pour login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> existingUser = utilisateurService.trouverParEmail(utilisateur.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(utilisateur.getPassword())) {
            return ResponseEntity.ok(existingUser.get());
        } else {
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect.");
        }
    }
}
