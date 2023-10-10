package com.example.backescapegame.controllers;


import com.example.backescapegame.entities.Utilisateur;
import com.example.backescapegame.repositories.UtilisateurRepository;
import com.example.backescapegame.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping(value = "/utilisateurs")
    ResponseEntity<List<Utilisateur>> allUtilisateurs() {

        return ResponseEntity.ok((List<Utilisateur>) utilisateurRepository.findAllByOrderByScoreDesc());
    }

    @PostMapping(value = "/creerUtilisateur")
    void insertUser(@RequestBody Utilisateur body) {
        utilisateurRepository.save(body);
    }

    @GetMapping(value = "/scoreMax")
    Integer scoreMax() {
        return utilisateurRepository.findMaxScore();
    }

    //test
    @GetMapping(value = "/utilisateurScoreMax")
    Utilisateur utilisateurMaxScore() {
        return utilisateurRepository.findUtilisateurMaxScore();
    }

    @GetMapping(value = "/scoreUtilisateur/{id}")
    Optional<Utilisateur> scoreUtilisateur(@PathVariable Integer id) {
        return utilisateurRepository.findById(id);
    }

    @PostMapping(value = "/envoiMail/{id}")
    String envoiMail(@PathVariable Integer id) {
        System.out.printf("id = %s%n", id);
        return utilisateurService.envoyerMail(id);
    }

}
