import java.util.ArrayList;
import java.util.List;

public class Benchmark {

    private final List<String[]> benchmarks;
    private final Map map;

    /**
     * 
     */
    public Benchmark(Map map) {
        this.benchmarks = new ArrayList<>();
        benchmarks.add(new String[] { "Malmö", "Stockholm", "300" });
        benchmarks.add(new String[] { "Göteborg", "Stockholm", "500" });
        benchmarks.add(new String[] { "Malmö", "Stockholm", "500" });
        benchmarks.add(new String[] { "Stockholm", "Sundsvall", "500" });
        benchmarks.add(new String[] { "Stockholm", "Umeå", "500" });
        benchmarks.add(new String[] { "Göteborg", "Sundsvall", "500" });
        benchmarks.add(new String[] { "Umeå", "Umeå", "500" });
        benchmarks.add(new String[] { "Sundsvall", "Umeå", "500" });
        benchmarks.add(new String[] { "Umeå", "Göteborg", "500" });
        benchmarks.add(new String[] { "Göteborg", "Umeå", "500" });
        this.map = map;
    }

    public void run(Depth depth) {
        for (String[] entry : benchmarks) {
            City from = map.lookup(entry[0]);
            City to = map.lookup(entry[1]);
            Integer max = Integer.valueOf(entry[2]);
            run(depth, from, to, max);
        }
    }

    private void run(Depth depth, City from, City to, Integer max) {
        if (from == null || to == null) {
            return;
        }
        long t0 = System.nanoTime();
        Integer distance = depth.shortest(from, to, max);
        long t1 = System.nanoTime() - t0;

        System.out.printf("FROM: %s TO: %s, shortest: %d min (%d ms)\n", from.getName(), to.getName(), distance, t1);

    }
}
