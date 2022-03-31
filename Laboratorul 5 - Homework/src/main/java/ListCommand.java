import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command {
    //ListCommand afiseaza continutul catalogului
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public ListCommand()
    {

    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void listCommand(Catalog catalog) {
       for(int i=0;i<catalog.getCatalog().size();i++)
           System.out.println("{'Id="+catalog.getCatalog().get(i).getId()+
                  ", Title=" +catalog.getCatalog().get(i).getTitle()+ ", Location="+
                   catalog.getCatalog().get(i).getLocation()+ ", " +catalog.getCatalog().get(i));
    }


    @Override
    public void execute(Catalog catalog,Item obj) {
        listCommand(catalog);
    }
}
