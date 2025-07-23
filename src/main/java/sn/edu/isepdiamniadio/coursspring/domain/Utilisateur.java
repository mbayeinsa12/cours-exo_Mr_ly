package sn.edu.isepdiamniadio.coursspring.domain;

import jakarta.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Long professeurId;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public Long getProfesseurId() { return professeurId; }
    public void setProfesseurId(Long professeurId) { this.professeurId = professeurId; }
}