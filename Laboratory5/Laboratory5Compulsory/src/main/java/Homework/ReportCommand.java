package Homework;

import Compulsory.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;

public class ReportCommand implements Command {

    private Catalog currentCatalogue;

    public ReportCommand(Catalog catalog) {
        this.currentCatalogue = catalog;
    }

    @Override
    public void executeCommand() {
        try {
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File("C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/target/FreemakerTemplate"));
            Template template = configuration.getTemplate("CatalogueReport.ftl");
            FileOutputStream fileOutput = new FileOutputStream("C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/target/FreemakerTemplate/ReportDone.html");
            OutputStreamWriter writeIn = new OutputStreamWriter(fileOutput);
            template.process(currentCatalogue, writeIn);
            writeIn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        } finally {
            ViewCommand view = new ViewCommand(this.currentCatalogue, "C:/Users/Valeria/Desktop/AN2SEM2/Programare_avansata/PA_2023/Laboratory5/Laboratory5Compulsory/target/FreemakerTemplate/ReportDone.html");
            view.executeCommand();
        }
    }
}
