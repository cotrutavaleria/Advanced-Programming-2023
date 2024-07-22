package Homework;

import Compulsory.Catalog;

import java.util.List;

public class ListCommand implements Command {
    private Catalog currentCatalogue;

    public ListCommand(Catalog catalog) {
        this.currentCatalogue = catalog;
    }

    @Override
    public void executeCommand() {
        System.out.println("Documents existing in "+ this.currentCatalogue.getName() + ":\n" + this.currentCatalogue.getDocs() + "\n");
    }
}
