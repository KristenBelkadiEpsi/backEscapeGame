package com.example.backescapegame.controllers;



import com.example.backescapegame.entities.Utilisateur;
import com.example.backescapegame.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @GetMapping(value="/utilisateurs")
    ResponseEntity<Iterable<Utilisateur>> allUtilisateurs(){

        return ResponseEntity.ok(utilisateurRepository.findAll());
    }
    @PostMapping(value="/creerUtilisateur")
    void insertUser(@RequestBody Utilisateur body){
        utilisateurRepository.save(body);
    }
    @GetMapping(value = "/scoreMax")
    Integer scoreMax(){
        return utilisateurRepository.findMaxScore();
    }
    @GetMapping(value = "/utilisateurScoreMax")
    Utilisateur utilisateurMaxScore(){
        return utilisateurRepository.findUtilisateurMaxScore();
    }
    @GetMapping(value="/scoreUtilisateur/{id}")
    Optional<Utilisateur> scoreUtilisateur(@PathVariable Integer id){
        return utilisateurRepository.findById(id);
    }

}
