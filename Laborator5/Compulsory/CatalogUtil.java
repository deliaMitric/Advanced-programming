package org.example.compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void save(Catalog catalog, String path) throws IOException {//salveaza catalogul fisierul json

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog.toString());
    }


    public static Catalog load(String path) throws  IOException {//citeste catalogul din fisierul json
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }
}
