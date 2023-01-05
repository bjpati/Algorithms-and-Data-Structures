public class Paths implements Depth {

    static City[] path;
    static int sp;

    /**
     * 
     */
    public Paths() {
        path = new City[54];
        sp = 0;
    }

    @Override
    public Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shortest = null;
        for (int i = 0; i < sp; i++) {
            if (path[i] == from) {
                return null;
            }
        }
        path[sp++] = from;
        int i = 0;
        while (from.getDestinations().get(i) != null) {
            Connection conn = from.getDestinations().get(i);
            Integer distance = shortest(to, from, max - conn.getDistance());
            if (distance != null) {
                distance += conn.getDistance();
                if (shortest == null) {
                    shortest = distance;
                } else if (distance.compareTo(shortest) > 0) {
                    shortest = distance;
                }
            }
        }
        path[sp--] = null;
        return shortest;
    }

}
