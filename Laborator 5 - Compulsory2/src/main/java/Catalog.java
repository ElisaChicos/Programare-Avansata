import java.util.List;

public class Catalog {
    private List<Item> catalog;

    private void adaugare(Item item){
        catalog.add(item);
    }

    private void load(Catalog catalog)
    {

    }

    private void save(Catalog catalog)
    {
        
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "catalog=" + catalog +
                '}';
    }
}
