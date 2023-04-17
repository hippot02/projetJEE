package com.example.projetjee.model;


import javax.persistence.*;

@Entity
@Table(name = "notation")
public class notation {

    @Column(name = "note")
    private int name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long userID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programme_id")
    Long programmmeId;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getProgrammmeId() {
        return programmmeId;
    }

    public void setProgrammmeId(Long programmmeId) {
        this.programmmeId = programmmeId;
    }
}
