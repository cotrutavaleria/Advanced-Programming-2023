package Compulsory;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CatalogCommands {
    public CatalogCommands() {
    }

    public static void save(Catalog catalog, String pathname) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathname), catalog);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }

    public static Catalog load(String path) {
        Catalog catalog = new Catalog();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!path.toLowerCase().endsWith(".json")) {
                throw new InvalidCatalogException("Path " + path + " is not valid.");
            }
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (InvalidCatalogException | IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return catalog;
    }
}
