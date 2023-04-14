package com.example.projetjee.model;

import jakarta.persistence.*;

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
}
