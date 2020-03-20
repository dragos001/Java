package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void testCreateSave() throws IOException {

        Catalog catalog = new Catalog("CATALOG1",
                "C:\\Users\\Dragos\\Desktop\\Fac\\catalog.ser");
        Document doc = new Document("java1",
                "Java Course 1",
                "C:\\Users\\Dragos\\Desktop\\Fac\\poza.png");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Dragos\\Desktop\\Fac\\catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);

    }

}
