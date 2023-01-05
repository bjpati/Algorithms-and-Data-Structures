import java.util.HashMap;
import java.util.LinkedList;

/**
 * City
 */
public class City {

    private final String name;
    private final LinkedList<Connection> destinations;

    /**
     * 
     */
    public City(String name) {
        this.name = name;
        this.destinations = new LinkedList<>();
    }

    void addConnection(City destination, Integer distance) {

        destinations.add(new Connection(destination, distance));
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.isEmpty() ? "" : name;
    }

    /**
     * @return the destinations
     */
    public LinkedList<Connection> getDestinations() {
        return destinations;
    }

}