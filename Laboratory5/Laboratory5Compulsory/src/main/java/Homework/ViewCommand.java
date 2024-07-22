package Homework;

import Compulsory.Catalog;
import Compulsory.Document;
import Compulsory.InvalidCatalogException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    private Catalog currentCatalogue;
    private String docsInfo;
    private String docPath;

    public ViewCommand(Catalog catalog, String info) {
        this.currentCatalogue = catalog;
        this.docsInfo = info;
        this.docPath = null;
    }

    @Override
    public void executeCommand() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (!this.docsInfo.endsWith("ReportDone.html")) {
                    for (Document document : currentCatalogue.getDocs()) {
                        if (document.getId().equals(this.docsInfo)) {
                            this.docPath = document.getPath();
                            desktop.open(new File(this.docPath));
                        }
                    }
                    if (this.docPath == null) {
                        throw new InvalidCatalogException("File is not valid!");
                    }
                } else {
                    this.docPath = this.docsInfo;
                    desktop.browse(new File(this.docPath).toURI());
                }

            }

        } catch (InvalidCatalogException | IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
