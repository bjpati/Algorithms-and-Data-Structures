/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        String file = "trains.csv";
        Map map = new Map(file);
        Benchmark benchmark = new Benchmark(map);
        benchmark.run(new Naive());
        benchmark.run(new Paths());
    }

}