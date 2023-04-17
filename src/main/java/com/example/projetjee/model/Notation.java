package com.example.projetjee.model;

import javax.persistence.*;

@Entity
@Table(name = "notation")
public class Notation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float value;

    @Column(nullable = true)
    private Float value2;

    @Column(nullable = true)
    private Float value3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getValue2() {
        return value2;
    }

    public void setValue2(Float value2) {
        this.value2 = value2;
    }

    public Float getValue3() {
        return value3;
    }

    public void setValue3(Float value3) {
        this.value3 = value3;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
