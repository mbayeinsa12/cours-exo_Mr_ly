package sn.edu.isepdiamniadio.coursspring.domain;

public class Etudiant {
    private  Long numeroEtudiant;
    private String prenom;
    private String nom;
    private String adresse;

    public Long getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(Long numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString(){
        return "je suis l'etudiant: "
                +numeroEtudiant+" repondant au nom de:"
                +prenom
                +" "+ nom
                +" habitant: "+adresse;
    }
}
