package com.cb.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "utilisateurs")
public class Utilisateur {
    @Id
    private String id;
    private String nom;
    private String adresse;
}
