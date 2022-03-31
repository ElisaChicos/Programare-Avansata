import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public interface Command {

    void execute(Catalog catalog,Item obj) throws TikaException, IOException, SAXException, InvalidCatalogException, Exception;
}