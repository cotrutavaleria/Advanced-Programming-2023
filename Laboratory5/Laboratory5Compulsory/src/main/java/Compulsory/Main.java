package Compulsory;

public class Main {
    public static void main(String args[]) {
        testCreateSave();
        testLoadView();
    }

    private static void testCreateSave()  {
        Catalog catalog = new Catalog("MyDocuments");
        var textFile = new Document("textFile1", "Lorem Ipsum","C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/LoremIpsum.txt" );
        catalog.add(textFile);
        var book = new Document("book1", "Jane Eyre","C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/LoremIpsum.txt" );
        book.addTag("author", new String("Charlotte Bronte"));
        catalog.add(book);
        CatalogCommands.save(catalog, "C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/catalog.json");
    }
    private static void testLoadView() {
        Catalog catalog = CatalogCommands.load("C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/LoremIpsum.txt");//generates an error
        Catalog catalog1 = CatalogCommands.load("C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/catalog.json");
    }
}
