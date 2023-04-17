package com.example.projetjee.model;
import javax.persistence.*;

@Entity
@Table(name = "programmes")
public class programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
