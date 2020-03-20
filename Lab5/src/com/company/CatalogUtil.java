package com.company;

import java.awt.*;
import java.io.*;


public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(doc.getLocation());
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
