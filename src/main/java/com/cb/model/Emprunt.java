package com.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "emprunts")
public class Emprunt {
    @Id
    private String id;
    private Date dateEmprunt;
    private Date dateRetour;
    private String idUtilisateur;
    private String idMedia;
    private String typeMedia;
}
