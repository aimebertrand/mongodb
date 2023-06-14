package com.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "impression")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Impression {
    @Id
    private Key id;
    private long siteId;
    private long contentId;
    private int impression;

    public Impression(Key id) {
        this.id = id;
    }
}
