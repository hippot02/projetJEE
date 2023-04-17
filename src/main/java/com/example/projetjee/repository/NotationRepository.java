package com.example.projetjee.repository;


import com.example.projetjee.model.Notation;
import com.example.projetjee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotationRepository extends JpaRepository<Notation, Long> {
    Notation findByUser(User user);
}
