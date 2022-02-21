package com.zikozee.prepostauthorization.repo;

import com.zikozee.prepostauthorization.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@Repository
public class DocumentRepository {

    private final Map<String, Document> documents =
            Map.of("abc123", new Document("natalie"),
                    "qwe123", new Document("natalie"),
                    "asd555", new Document("emma"));

    public Document findDocument(String code){
        return documents.get(code);
    }
}
