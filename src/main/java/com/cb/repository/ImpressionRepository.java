package com.cb.repository;

import com.cb.model.Impression;
import com.cb.model.Key;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Optional;

public interface ImpressionRepository extends MongoRepository<Impression, Key> {

    @Query("{siteId : ?0}")
    Optional<Impression> getImpressionBySiteId(long siteId);
}
