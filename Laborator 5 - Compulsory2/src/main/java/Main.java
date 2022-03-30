import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Catalog catalog = new Catalog();
        Books item1 = new Books(1967,"Donald E. Knuth");
        item1.setId("knuth67");
        item1.setTitle("The Art of Computer Programming");
        item1.setLocation("d:/books/programming/tacp.ps");

        Item item2 = new Article(2021,"James Gosling & others","book");
        item2.setId("java17");
        item2.setTitle("The Java Language Specification");
        item2.setLocation("https://docs.oracle.com/javase/specs/jls/se17/html/index.html");

        catalog.add(item1);
        catalog.add(item2);
        catalog.toString();

//       catalog.save(catalog,"C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 5 - Compulsory2\\src\\main\\java\\input.json");
        catalog.load("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 5 - Compulsory2\\src\\main\\java\\input.json");
    }

}
