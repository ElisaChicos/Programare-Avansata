

public class LocalItems extends Item {
    private int year;
    private String autor;

    public LocalItems(int year, String autor) {
        this.year = year;
        this.autor = autor;
    }

    public LocalItems(int id, String name, String location, int year, String autor) {
        super(id, name, location);
        this.year = year;
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "LocatItems{" +
                "year=" + year +
                ", autor='" + autor + '\'' +
                '}';
    }
}
