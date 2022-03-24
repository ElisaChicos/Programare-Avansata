import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class City {
    Map<Intersections, List<Streets>> cityMap = new HashMap<>();

    public City(Map<Intersections, List<Streets>> cityMap) {
        this.cityMap = cityMap;
    }

    public City() {

    }

    public Map<Intersections, List<Streets>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersections, List<Streets>> cityMap) {
        this.cityMap = cityMap;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityMap=" + cityMap +
                '}';
    }

}
