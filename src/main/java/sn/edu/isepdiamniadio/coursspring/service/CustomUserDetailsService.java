package sn.edu.isepdiamniadio.coursspring.service;

import sn.edu.isepdiamniadio.coursspring.domain.Utilisateur;
//import sn.edu.isepdiamniadio.coursspring.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.coursspring.repositories.UtilisateurRepository;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByLogin(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
        return new User(
                utilisateur.getLogin(),
                utilisateur.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().getNom()))
        );
    }
}