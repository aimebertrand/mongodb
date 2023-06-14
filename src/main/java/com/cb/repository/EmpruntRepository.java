package com.cb.repository;

import com.cb.model.Emprunt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends MongoRepository<Emprunt, Integer> {
}

