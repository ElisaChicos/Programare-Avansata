import java.util.Map;

public class Article extends Item {
    private int year;
    private String autor;
    private String type;

    public Article(String id, String title, String location, int year, String autor, String type) {
        super(id, title, location);
        this.year = year;
        this.autor = autor;
        this.type = type;
    }

    public  Article(){

    }
    public Article(int year, String autor, String type) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "year=" + year +
                ", autor='" + autor + '\'' +
                ", type=" + type +
                '}';
    }
}
