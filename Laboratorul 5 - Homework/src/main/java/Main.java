

public class Main {

    public static void main(String[] args) throws Exception {
        Catalog catalog = new Catalog();
        Books item1 = new Books("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth");
        Item item2 = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "book");

        AddComand ac = new AddComand();
        ac.addItem(item1, catalog);
        ac.addItem(item2, catalog);

        ListCommand a = new ListCommand();
        a.listCommand(catalog);
        a.execute(catalog,item1);

        ViewCommand v = new ViewCommand();
//        v.execute(catalog,item1);

        SaveCommand s = new SaveCommand();
//        s.execute(catalog,item1);


        LoadCommand l = new LoadCommand();
//        l.execute(catalog,item1);

        ReportCommand r = new ReportCommand();
//        r.execute(catalog,item1);


        InfoCommand i = new InfoCommand();
        i.execute(catalog,item1);



    }


}
