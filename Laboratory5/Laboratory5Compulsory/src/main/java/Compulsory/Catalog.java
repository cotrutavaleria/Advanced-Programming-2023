package Compulsory;

import Homework.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs;

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
        docs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void add(Document doc) {
        docs.add(doc);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Catalog catalog = (Catalog) obj;
        if (this.name == catalog.getName()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", docs=" + docs + "}";
    }

    public void executeACommand(String command, String pathOrDocsId) {
        try {
            switch (command) {
                case "load":
                    AddCommand add = new AddCommand(this, pathOrDocsId);
                    add.executeCommand();
                    break;
                case "list":
                    ListCommand list = new ListCommand(this);
                    list.executeCommand();
                    break;
                case "view":
                    ViewCommand view = new ViewCommand(this, pathOrDocsId);
                    view.executeCommand();
                    break;
                case "report":
                    ReportCommand report = new ReportCommand(this);
                    report.executeCommand();
                    break;
                default:
                    throw new InvalidCatalogException("The command does not exist!");
            }
        } catch (InvalidCatalogException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
