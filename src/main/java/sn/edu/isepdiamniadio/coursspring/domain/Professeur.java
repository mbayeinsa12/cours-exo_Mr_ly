package sn.edu.isepdiamniadio.coursspring.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;

    private String nom;

    private int age;

    private String adresse;

    private String matiere;


    @ManyToMany(mappedBy = "professeurs")
    private List<Ecole> ecoles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public List<Ecole> getEcoles() {
        return ecoles;
    }

    public void setEcoles(List<Ecole> ecoles) {
        this.ecoles = ecoles;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", adresse='" + adresse + '\'' +
                ", matiere='" + matiere + '\'' +
                ", ecoles=" + ecoles +
                '}';
    }
}