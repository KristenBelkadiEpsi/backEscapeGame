package com.example.backescapegame.repositories;


import com.example.backescapegame.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    @Query("Select max(utilisateur.score) from Utilisateur utilisateur")
    Integer findMaxScore();

    List<Utilisateur> findAllByOrderByScoreDesc();

    List<Utilisateur> findAllByOrderByScoreAsc();

    Optional<Utilisateur> findById(Integer id);

    @Query("SELECT ut FROM Utilisateur ut WHERE ut.score = (SELECT MAX(u.score) FROM Utilisateur u)")
    Utilisateur findUtilisateurMaxScore();

}