public class Naive implements Depth {

    @Override
    public Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shortest = null;
        if (from == null) {
            return shortest;
        }
        for (int i = 0; i < from.getDestinations().size(); i++) {
            if (from.getDestinations().get(i) == null) {
                return shortest;
            }
            if (from.getDestinations().get(i) != null) {
                Connection connection = from.getDestinations().get(i);
                Integer distance = shortest(connection.getCity(), to, max - connection.getDistance());
                if (distance != null) {
                    shortest = distance + connection.getDistance();
                }
                if (shortest != null && max > shortest) {
                    max = shortest;
                }
            }
        }
        return shortest;
    }
}
