package com.cb.repository;


import com.cb.model.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, Integer> {
}
