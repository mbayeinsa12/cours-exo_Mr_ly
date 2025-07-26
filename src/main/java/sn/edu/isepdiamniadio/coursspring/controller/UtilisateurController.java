package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.coursspring.domain.Utilisateur;
import sn.edu.isepdiamniadio.coursspring.repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()) {
            Utilisateur utilisateur = utilisateurOptional.get();
            utilisateur.setLogin(utilisateurDetails.getLogin());
            utilisateur.setPassword(utilisateurDetails.getPassword());
            utilisateur.setRole(utilisateurDetails.getRole());
            utilisateur.setProfesseurId(utilisateurDetails.getProfesseurId());
            return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            utilisateurRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}