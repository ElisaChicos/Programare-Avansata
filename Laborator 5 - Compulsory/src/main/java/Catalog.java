import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
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

    public void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);

    }

    public void load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        String content = stringBuilder.toString();
        Catalog catalog2 = objectMapper.readValue(content, Catalog.class);
        System.out.println(catalog2);
//        List<Item> catalog2 = objectMapper.readValue(content, new TypeReference<List<Catalog>>(){});
//        this.catalog = catalog2;
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
