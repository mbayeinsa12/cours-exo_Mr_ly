package sn.edu.isepdiamniadio.coursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.edu.isepdiamniadio.coursspring.domain.Etudiant;

@SpringBootApplication
public class CoursspringApplication implements CommandLineRunner {



	@Autowired(required = false)
	//@Qualifier("titi")
	Etudiant toto;

	Etudiant etudiant2;

	public CoursspringApplication(@Qualifier("unEtudiantDbe") Etudiant test){
		etudiant2 = test;

	}

	public static void main(String[] args) {
		SpringApplication.run(CoursspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(toto.toString());


		System.out.println("L'id de l'etudiant qui a été injecté est:" + toto.getNumeroEtudiant());
		System.out.println("L'adresse de l'etudiant qui a été injecté est:" + toto.getAdresse());


		System.out.println("----------");
		System.out.println("Letudiant 2 est:"+ etudiant2.toString());
	}
}
