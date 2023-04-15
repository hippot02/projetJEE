package com.example.projetjee.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "prenom")
    private String prenom;


    @Column(name = "nom")
    private String nom;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_programme",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "programme_id"))
    private Collection<Programme> progammes;


    //    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //    @JoinTable(name = "user_programme",
    //            joinColumns = @JoinColumn(name = "user_id"),
    //            inverseJoinColumns = @JoinColumn(name = "programme_id"))
    //    private Collection<Role> roles;

    public User(String prenom, String nom, String email, String password, Collection<Programme> progammes) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.progammes = progammes;
    }

    public User(int id, String prenom, String nom, String email, String password, Collection<Programme> progammes) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.progammes = progammes;
    }

    public User() {

   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Programme> getProgammes() {
        return progammes;
    }

    public void setProgammes(Collection<Programme> progammes) {
        this.progammes = progammes;
    }
//    public Collection<Role> getRoles() {
//        return roles;
//    }
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }


}
