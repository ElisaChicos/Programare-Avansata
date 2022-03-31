
public class AddComand implements Command {
    //Clasa Add adauga un element de tip Item in catalog
    public Catalog catalog;

    public AddComand(Catalog catalog) {
        this.catalog = catalog;
    }
    public AddComand()
    {

    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addItem(Item i,Catalog catalog){
        catalog.add(i);
    }

    @Override
    public void execute(Catalog catalog,Item obj) {
        addItem(obj, catalog);
    }
}
