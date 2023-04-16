package com.example.projetjee.model;
import javax.persistence.*;

@Entity
@Table(name = "programmes")
public class programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




}
