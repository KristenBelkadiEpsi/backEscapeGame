package com.example.backescapegame.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Utilisateur")
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="email")
    private String email;
    @Column(name = "nom")
    @Nonnull
    private String nom;

    @Column(name = "score")
    private Integer score = 0;

    public Utilisateur(String nom,Integer score){
        this.nom=nom;
        this.score=score;
    }
}