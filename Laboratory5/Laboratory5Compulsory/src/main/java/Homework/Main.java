package Homework;

import Compulsory.Catalog;
import Compulsory.CatalogCommands;
import Compulsory.Document;


public class Main {
    public static void main(String args[]) {
        Catalog catalog = new Catalog("MyDocuments");
        var textFile = new Document("textFile1", "Lorem Ipsum", "C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/LoremIpsum.txt");
        catalog.add(textFile);
        var book = new Document("book1", "Jane Eyre", "C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/LoremIpsum.txt");
        book.addTag("author", new String("Charlotte Bronte"));
        catalog.add(book);
        CatalogCommands.save(catalog, "C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/catalog.json");
        testCommands(catalog);
    }

    private static void testCommands(Catalog catalog) {
        catalog.executeACommand("load", "C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/catalog.json");
        catalog.executeACommand("list", "");
        catalog.executeACommand("view", "book1");
        catalog.executeACommand("view", "book12");//generates an error
        catalog.executeACommand("report", "");
    }
}