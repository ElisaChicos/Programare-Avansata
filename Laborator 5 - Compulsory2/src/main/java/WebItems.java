
public class WebItems extends Item {
    private int year;
    private String autor;
    private int type;

    public WebItems(int year, String autor, int type) {
        this.year = year;
        this.autor = autor;
        this.type = type;
    }

    public WebItems(int id, String name, String location, int year, String autor, int type) {
        super(id, name, location);
        this.year = year;
        this.autor = autor;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WebItems{" +
                "year=" + year +
                ", autor='" + autor + '\'' +
                ", type=" + type +
                '}';
    }
}
