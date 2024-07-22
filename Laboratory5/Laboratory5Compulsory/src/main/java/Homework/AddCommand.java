package Homework;

import Compulsory.Catalog;
import Compulsory.InvalidCatalogException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AddCommand implements Command{
    private Catalog currentCatalogue;
    private String path;

    public AddCommand(Catalog catalog, String path) {
        this.currentCatalogue = catalog;
        this.path = path;
    }

    public void executeCommand () {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!this.path.toLowerCase().endsWith(".json")) {
                throw new InvalidCatalogException("File is not valid.");
            }
            this.currentCatalogue = objectMapper.readValue(new File(this.path), Catalog.class);
        } catch (InvalidCatalogException | IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println("Your catalogue was loaded\n");
    }
}
