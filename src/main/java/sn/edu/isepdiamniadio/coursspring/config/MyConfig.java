package sn.edu.isepdiamniadio.coursspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import sn.edu.isepdiamniadio.coursspring.domain.Etudiant;

@Configuration
public class MyConfig {
   @Value("${etudiant1.numetudiant}")
    private Long numEtudiant1;
    @Value("Samba")
    private String prenomEtudiant1;
    @Value("${etudiant1.nom}")
    private String nomEtudiant1;
    @Value("${etudiant1.adresse}")
    private String adresseEtudiant1;

    @Value("${etudiant2.numetudiant}")
    private Long numEtudiant2;
    @Value("${etudiant2.prenom}")
    private String prenomEtudiant2;
    @Value("${etudiant2.nom}")

    private String nomEtudiant2;
    @Value("${etudiant2.adresse}")
    private String adresseEtudiant2;

    @Value("${etudiant3.numetudiant}")
    private Long numEtudiant3;
    @Value("${etudiant3.prenom}")
    private String prenomEtudiant3;
    @Value("${etudiant3.nom}")

    private String nomEtudiant3;
    @Value("${etudiant3.adresse}")
    private String adresseEtudiant3;

    @Bean("isep")
    public Etudiant etudiant(){
        Etudiant etudiant = new Etudiant();
        etudiant.setNumeroEtudiant(numEtudiant1);
        etudiant.setPrenom(prenomEtudiant1);
        etudiant.setNom(nomEtudiant1);
        etudiant.setAdresse(adresseEtudiant1);
        return etudiant;
    }

    @Bean(name="toto")
    public Etudiant unAutreEtudiant(){
        Etudiant etudiant = new Etudiant();
        etudiant.setNumeroEtudiant(numEtudiant2);
        etudiant.setPrenom(prenomEtudiant2);
        etudiant.setNom(nomEtudiant2);
        etudiant.setAdresse(adresseEtudiant2);
        return etudiant;
    }

    @Bean
   // @Primary
    public Etudiant unEtudiantDbe(){
        Etudiant etudiant = new Etudiant();
        etudiant.setNumeroEtudiant(numEtudiant3);
        etudiant.setPrenom(prenomEtudiant3);
        etudiant.setNom(nomEtudiant3);
        etudiant.setAdresse(adresseEtudiant3);
        return etudiant;
    }
}
