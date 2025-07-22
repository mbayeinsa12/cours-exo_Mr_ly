package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepdiamniadio.coursspring.domain.Professeur;
import sn.edu.isepdiamniadio.coursspring.service.ProfesseurService;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;


    @GetMapping
    public Page<Professeur> listerProfesseurs(@PageableDefault(sort = "nom") Pageable pageable) {
        return professeurService.listerProfesseurs(pageable);
    }

    // Endpoint pour rechercher les professeurs vivant dans les établissements où ils enseignent
    @GetMapping("/memeAdresse")
    public List<Professeur> rechercherProfesseursMemeAdresse() {
        return professeurService.rechercherProfesseursMemeAdresse();
    }
}