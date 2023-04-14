package com.example.projetjee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "programmes")
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;

    private String sport1;

    public Programme(String nom, String description, String sport1, String sport2, String sport3) {
        this.nom = nom;
        this.description = description;
        this.sport1 = sport1;
        this.sport2 = sport2;
        this.sport3 = sport3;
    }

    private String sport2;

    public Programme(String nom) {
        this.nom = nom;
        this.description = "Programme d'acceuil comprenant 3 sport a faire en série de 10min de course à pied, 10min de vélo et 10min de corde";
        this.sport1 = "Course à pied";
        this.sport2 = "Vélo";
        this.sport3 = "Corde à sauter";
    }

    public Programme() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSport1() {
        return sport1;
    }

    public void setSport1(String sport1) {
        this.sport1 = sport1;
    }

    public String getSport2() {
        return sport2;
    }

    public void setSport2(String sport2) {
        this.sport2 = sport2;
    }

    public String getSport3() {
        return sport3;
    }

    public void setSport3(String sport3) {
        this.sport3 = sport3;
    }

    public static int getNoteProgramme() {
        return noteProgramme;
    }

    public static void setNoteProgramme(int noteProgramme) {
        Programme.noteProgramme = noteProgramme;
    }

    private String sport3;

    private static int noteProgramme;
}
