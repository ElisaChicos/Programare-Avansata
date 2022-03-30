import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Catalog catalog = new Catalog();
        Books item1 = new Books("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth");
        Item item2 = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "book");

        AddComand ac = new AddComand();
        ac.addItem(item1, catalog);
        ac.addItem(item2, catalog);

        ListCommand a = new ListCommand();
//        a.listCommand(catalog);

        ViewCommand v = new ViewCommand();
//        v.openItem("E:\\Downloads\\gauss.txt");

        SaveCommand s = new SaveCommand();
        s.SaveJsonCatalog(catalog, "C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\java\\input.json");

        LoadCommand l = new LoadCommand();
        Catalog catalog2 = l.LoadJson("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\java\\input.json");

        a.listCommand(catalog2);

        ReportCommand r = new ReportCommand();
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
//        r.doGet(catalog, request, response);
        r.report(catalog);


        InfoCommand i = new InfoCommand();
//        i.metadataDisplay("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\resources\\Templates\\HTMLfile.ftl");

    }


}
