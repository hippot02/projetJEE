package com.example.projetjee.web;

import com.example.projetjee.model.Notation;
import com.example.projetjee.model.User;
import com.example.projetjee.repository.NotationRepository;
import com.example.projetjee.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    private final UserRepository userRepository;
    private Float noteLocal1;
    private Float noteLocal2;
    private Float noteLocal3;
    private final NotationRepository notationRepository;

    @Autowired
    public IndexController(NotationRepository notationRepository, UserRepository userRepository) {
        this.notationRepository = notationRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/index")
    public String note(Model model,
                       @RequestParam(name = "note", required = false) Integer note1,
                       @RequestParam(name = "note2", required = false) Integer note2,
                       @RequestParam(name = "note3", required = false) Integer note3) {
        if (note1 != null) {
            this.noteLocal1 = note1.floatValue();
            saveNotation(note1.floatValue(), 1);
        }
        model.addAttribute("note", noteLocal1);

        if (note2 != null) {
            noteLocal2 = note2.floatValue();
            saveNotation(note2.floatValue(), 2);
        }
        model.addAttribute("note2", noteLocal2);

        if (note3 != null) {
            noteLocal3 = note3.floatValue();
            saveNotation(note3.floatValue(), 3);
        }
        model.addAttribute("note3", noteLocal3);

        List<Notation> notations = notationRepository.findAll();
        float moyenne1 = calculerMoyenne1(notations);
        model.addAttribute("moyenne1", String.format("%.1f", moyenne1));
        float moyenne2 = calculerMoyenne2(notations);
        model.addAttribute("moyenne2", String.format("%.1f", moyenne2));
        float moyenne3 = calculerMoyenne3(notations);
        model.addAttribute("moyenne3", String.format("%.1f", moyenne3));

        return "index";
    }

    @GetMapping("/index")
    public String note(Model model) {
        List<Notation> notations = notationRepository.findAll();
        float moyenne1 = calculerMoyenne1(notations);
        model.addAttribute("moyenne1", String.format("%.1f", moyenne1));
        float moyenne2 = calculerMoyenne2(notations);
        model.addAttribute("moyenne2", String.format("%.1f", moyenne2));
        float moyenne3 = calculerMoyenne3(notations);
        model.addAttribute("moyenne3", String.format("%.1f", moyenne3));
        return "index";
    }

        private void saveNotation(float value, int index) {
            String username = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            User user = userRepository.findByEmail(username);
            Notation existingNotation = notationRepository.findByUser(user);

            if (existingNotation != null) {
                if (index == 1) {
                    existingNotation.setValue((int) value);
                } else if (index == 2) {
                    existingNotation.setValue2((int) value);
                } else if (index == 3) {
                    existingNotation.setValue3((int) value);
                }
                notationRepository.save(existingNotation);
            } else {
                Notation notation = new Notation();
                if (index == 1) {
                    notation.setValue((int) value);
                } else if (index == 2) {
                    notation.setValue2((int) value);
                } else if (index == 3) {
                    notation.setValue3((int) value);
                }
                notation.setUser(user);
                notationRepository.save(notation);
            }
        }



        private float calculerMoyenne1(List<Notation> notations) {
            float somme = 0;
            int nbNotes = 0;
            for (Notation notation : notations) {
                if(notation.getValue() != null) {
                    somme += notation.getValue();
                    nbNotes++;
                }
            }
            return nbNotes == 0 ? 0 : Math.round((somme / nbNotes) * 10.0f) / 10.0f;
        }

        private float calculerMoyenne2(List<Notation> notations) {
            float somme = 0;
            int nbNotes = 0;
            for (Notation notation : notations) {
                if(notation.getValue2() != null) {
                    somme += notation.getValue2();
                    nbNotes++;
                }
            }
            return nbNotes == 0 ? 0 : Math.round((somme / nbNotes) * 10.0f) / 10.0f;
        }

        private float calculerMoyenne3(List<Notation> notations) {
            float somme = 0;
            int nbNotes = 0;
            for (Notation notation : notations) {
                if(notation.getValue3() != null) {
                    somme += notation.getValue3();
                    nbNotes++;
                }
            }
            return nbNotes == 0 ? 0 : Math.round((somme / nbNotes) * 10.0f) / 10.0f;
        }


    }



