//package sn.edu.isepdiamniadio.coursspring.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sn.edu.isepdiamniadio.coursspring.domain.Etudiant;
//
//@RestController
//public class EtudiantTestController {
//
//    @Autowired
//    private Etudiant isep;
//
//    @Autowired
//    private Etudiant toto;
//
//    @Autowired
//    private Etudiant unEtudiantDbe;
//
//    @GetMapping("/test/isep")
//    public Etudiant getIsep() {
//        return isep;
//    }
//
//    @GetMapping("/test/toto")
//    public Etudiant getToto() {
//        return toto;
//    }
//
//    @GetMapping("/test/dbe")
//    public Etudiant getDbe() {
//        return unEtudiantDbe;
//    }
//}