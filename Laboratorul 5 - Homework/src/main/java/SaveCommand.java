import java.io.IOException;

public class SaveCommand {
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

    public void SaveJsonCatalog(Catalog catalog,String path) throws IOException {
        CatalogUtil.save(catalog,path);
    }
}
