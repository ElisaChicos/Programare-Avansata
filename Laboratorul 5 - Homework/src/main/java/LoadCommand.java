import java.io.IOException;

public class LoadCommand implements Command {
    //LoadCommand citeste un fisier .json si memoreaza continul acestuia in catalog
    public Catalog catalog;

    public LoadCommand(Catalog catalog) {
        this.catalog = catalog;
    }
    public LoadCommand()
    {

    }
    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


    public Catalog LoadJson(String path) throws IOException, InvalidCatalogException {

         Catalog catalog = CatalogUtil.load(path);

        return catalog;

    }


    @Override
    public void execute(Catalog catalog, Item obj) throws IOException, InvalidCatalogException {
        catalog = LoadJson("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\java\\input.json");
    }
}
