package com.cb.controller;

import com.cb.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RestController
@RequestMapping("/consultation")
public class ControllerMongoTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    // Exemple de méthode pour obtenir les médias par type, triés par titre
// Exemple de méthode pour obtenir les médias par type, triés par titre
    @GetMapping("/byType/{type}")
    public List<Media> getMediaByType(@PathVariable String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type));
        query.with(Sort.by(Sort.Direction.ASC, "type"));
        return mongoTemplate.find(query, Media.class);
    }


    // Exemple de méthode pour grouper les médias par type et compter le nombre d'éléments dans chaque groupe
    @GetMapping("/groupedByType")
    public List<Media> getMediaGroupedByType() {
        Aggregation agg = newAggregation(
                group("type").count().as("count"),
                project("count").and("type").previousOperation()
        );

        return mongoTemplate.aggregate(agg, "media", Media.class).getMappedResults();
    }

    // Exemple de méthode pour mettre à jour en masse les médias en définissant leur disponibilité à faux
    @GetMapping("/updateAvailability")
    public String updateMediaAvailability() {
        Query query = new Query();
        query.addCriteria(Criteria.where("disponibilite").is(false));
        Update update = new Update();
        update.set("disponibilite", true);
        mongoTemplate.updateMulti(query, update, Media.class);
        return "Disponibilité mise à jour pour tous les médias";
    }
}
