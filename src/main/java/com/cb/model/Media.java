package com.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "media")
public class Media {
    @Id
    private String id;
    private String type;
    private String titre;
    private String auteurRealisateurEditeur;
    private boolean disponibilite;
}
