/**
 * Connection
 */
public class Connection {

    private final City city;
    private final Integer distance;

    public Connection(City city, Integer distance) {
        this.city = city;
        this.distance = distance;
    }

    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @return the distance
     */
    public Integer getDistance() {
        return distance;
    }

}