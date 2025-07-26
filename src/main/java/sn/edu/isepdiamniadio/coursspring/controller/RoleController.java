package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.coursspring.domain.Role;
import sn.edu.isepdiamniadio.coursspring.repositories.RoleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // Récupérer tous les rôles
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            List<Role> roles = roleRepository.findAll();
            if (roles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Récupérer un rôle par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        Optional<Role> roleData = roleRepository.findById(id);
        if (roleData.isPresent()) {
            return new ResponseEntity<>(roleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Créer un nouveau rôle
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        try {
            Role newRole = roleRepository.save(role);
            return new ResponseEntity<>(newRole, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mettre à jour un rôle
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
        Optional<Role> roleData = roleRepository.findById(id);

        if (roleData.isPresent()) {
            Role updatedRole = roleData.get();
            updatedRole.setNom(role.getNom());
            return new ResponseEntity<>(roleRepository.save(updatedRole), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un rôle
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteRole(@PathVariable("id") Long id) {
        try {
            Optional<Role> role = roleRepository.findById(id);
            if (!role.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            roleRepository.deleteById(id);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Le rôle a été supprimé avec succès!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Impossible de supprimer ce rôle");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}