import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    //Clasa catalog contine o lista de Item-uri
    private List<Item> catalog = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(List<Item> catalog) {
        this.catalog = catalog;
    }

    public List<Item> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Item> catalog) {
        this.catalog = catalog;
    }

    public void add(Item item) {
        catalog.add(item);
    }



    public Item findById(String id) {
        for (Item item : catalog) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        for (Item item : catalog)
            System.out.println(item);
        return "";
    }
}
