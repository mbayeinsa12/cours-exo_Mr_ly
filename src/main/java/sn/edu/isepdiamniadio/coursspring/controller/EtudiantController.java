package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class EtudiantController {

    //on passe par les PathVariable
    @GetMapping (value = "/home/nom/{nom}/age/{age}")
    public String getHome(Model model, @PathVariable String nom, @PathVariable int age){
        String message = "Bienvenue "+nom+" age de "+age+"ans dans la classe des experts Spring !";
        model.addAttribute("message",message);
        model.addAttribute("nom",nom);
        model.addAttribute("age",age);

        return "home";
    }

    //on passe par les RequestParam
    @RequestMapping(value = "/infos")
    public String getInfos(Model model,@RequestParam("nom") String name, @RequestParam("age") String years){
        String title = "Infos de l'écoles: Directeur: "+name +"  age:"+years ;
        String content = "Numeros utiles: 33 800 00 00 ";
        model.addAttribute("titre",title);
        model.addAttribute("content",content);
        return "infos";
    }

}
