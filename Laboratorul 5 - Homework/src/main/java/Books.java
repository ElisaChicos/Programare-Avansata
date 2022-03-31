import java.util.Map;

public class Books extends Item {
    //Clasa Books extinde clasa Item, prin urmare contine toate variabilele si in plus am adaugat autor si year
    private int year;
    private String autor;

    public Books(String id, String title, String location, int year, String autor) {
        super(id, title, location);
        this.year = year;
        this.autor = autor;
    }
    public Books()
    {

    }


    public Books(int year, String autor) {
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
        return "Books{" +
                "year=" + year +
                ", autor='" + autor + '\'' +
                '}';
    }
}
