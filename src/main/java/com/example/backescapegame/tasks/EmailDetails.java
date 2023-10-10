package com.example.backescapegame.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailDetails {
    private String destinataire;
    private String corps;
    private String sujet;
    private String pieceJointe;
}
