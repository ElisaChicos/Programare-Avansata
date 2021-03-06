import org.checkerframework.checker.units.qual.C;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    //Deschise un fisier din laptop utilizand clasa Desktop
    public Catalog catalog;

    public ViewCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public ViewCommand()
    {

    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


    public void openItem(String path)
    {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File(path);
                desktop.open(myFile);
            } catch (IOException ex) {}
        }
    }

    @Override
    public void execute(Catalog catalog, Item obj) {
        openItem("E:\\Downloads\\gauss.txt");
    }
}
