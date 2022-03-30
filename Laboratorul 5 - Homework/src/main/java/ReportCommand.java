
import java.awt.*;
import java.io.*;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = {"/"})
public class ReportCommand {
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
        Writer writer = new OutputStreamWriter(System.out);
        template.process(catalog, writer);
    }

//    public void report(Catalog catalog,HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html;charset=UTF-8");
//
//
//        request.setAttribute("catalog", catalog);
//
//        request.getRequestDispatcher("/HMLfile.ftl").forward(request, response);
//
//
//    }


}

