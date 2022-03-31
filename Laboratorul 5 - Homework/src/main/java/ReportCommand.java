
import java.awt.*;
import java.io.*;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "MyServlet", urlPatterns = {"/"})
public class ReportCommand implements Command {
    //Report command formeaza un fisier HTML cu ajutorul Freemarker-ului si il afiseaza in browser
    public Catalog catalog;

    public ReportCommand() {

    }

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void report(Catalog catalog) throws Exception {

        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(
                new File(Catalog.class.getResource("/Templates").toURI()));

        Template template = configuration.getTemplate("HTMLfile.ftl");
        FileWriter fw = new FileWriter("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\resources\\Templates\\fileEx.html");
        template.process(catalog, fw);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\resources\\Templates\\fileEx.html");
                desktop.open(myFile);
            } catch (IOException ex) {}
        }

    }

    @Override
    public void execute(Catalog catalog, Item obj) throws Exception {
        report(catalog);
    }
}

