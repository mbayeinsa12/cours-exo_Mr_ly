package sn.edu.isepdiamniadio.coursspring.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.edu.isepdiamniadio.coursspring.domain.Utilisateur;
import sn.edu.isepdiamniadio.coursspring.repositories.UtilisateurRepository;

// Ce la nous indique que cette classe est un contrôleur REST
@RestController
// Toutes les routes de ce contrôleur
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    // Injection du repository pour accéder aux données des utilisateurs
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Récupérer la liste de tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Récupérer un utilisateur par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        // Retourner l'utilisateur s'il existe, sinon retourner 404
        return utilisateur.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouvel utilisateur
    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Mettre à jour un utilisateur existant
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()) {
            Utilisateur utilisateur = utilisateurOptional.get();
            // Mise à jour des champs de l'utilisateur
            utilisateur.setLogin(utilisateurDetails.getLogin());
            utilisateur.setPassword(utilisateurDetails.getPassword());
            utilisateur.setRole(utilisateurDetails.getRole());
            utilisateur.setProfesseurId(utilisateurDetails.getProfesseurId());
            // Sauvegarder les modifications et retourner l'utilisateur mis à jour
            return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
        }
        // Retourner 404 si l'utilisateur n'existe pas
        return ResponseEntity.notFound().build();
    }

    // Supprimer un utilisateur par son identifiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            utilisateurRepository.deleteById(id);
            // Retourner 200 OK si la suppression a réussi
            return ResponseEntity.ok().build();
        }
        // Retourner 404 si l'utilisateur n'existe pas
        return ResponseEntity.notFound().build();
    }
}