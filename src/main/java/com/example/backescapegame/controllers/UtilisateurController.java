package com.example.backescapegame.controllers;



import com.example.backescapegame.entities.Utilisateur;
import com.example.backescapegame.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @GetMapping(value="/users")
    ResponseEntity<Iterable<Utilisateur>> allUtilisateurs(){

        return ResponseEntity.ok(utilisateurRepository.findAll());
    }
    @PostMapping(value="/createUser")
    void insertUser(@RequestBody Utilisateur body){
        utilisateurRepository.save(body);
    }

}
