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
@Table(name="User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @Nonnull
    private String username;

    @Column(name = "score")
    private Integer score = 0;

    public User(String username,Integer score){
        this.username=username;
        this.score=score;
    }
}