package org.example.compulsory;

import java.io.IOException;

public class Main {


    public static void main(String args[]) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoad();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("MyDocuments");
        var doc1 = new Document(1,"titludoc1","C:/Users/Delia/Desktop/Laborator5" );
        var doc2 = new Document(12,"titludoc2","C:/Users/Delia/Desktop/Laborator5" );
        catalog.add(doc1);
        catalog.add(doc2);

        CatalogUtil.save(catalog, "C:/Users/Delia/Desktop/Laborator5/catalog.json");
    }

    private void testLoad() throws IOException {
        Catalog catalog1 = CatalogUtil.load("C:/Users/Delia/Desktop/Laborator5/catalog.json");
        System.out.println(catalog1.toString());
        //CatalogUtil.view(catalog.findById("article1"));
    }

}