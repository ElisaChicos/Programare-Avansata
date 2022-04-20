import java.io.IOException;

public class SaveCommand implements Command {
    //Salveaza continutul catalofului intr-un fisier .json
    public Catalog catalog;

    public SaveCommand(Catalog catalog) {
        this.catalog = catalog;
    }
    public SaveCommand() {
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void SaveJsonCatalog(Catalog catalog,String path) throws IOException, InvalidCatalogException {
        CatalogUtil.save(catalog,path);
    }



    @Override
    public void execute(Catalog catalog, Item obj) throws IOException, InvalidCatalogException {
        SaveJsonCatalog(catalog,"C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laboratorul 5 - Homework\\src\\main\\java\\input.json");
    }
}
