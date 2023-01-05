import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    private City[] cities;

    public Map(String file) {
        this.cities = readFromFile(file);
    }

    private City[] readFromFile(String file) {
        cities = new City[541];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City cityA = lookup(row[0]);
                City cityB = lookup(row[1]);
                Integer distance = Integer.valueOf(row[2]);
                cityA.addConnection(cityB, distance);
                cityB.addConnection(cityA, distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt.");
        }
        return cities;
    }

    public City lookup(String name) {
        Integer index = hash(name);
        if (cities[index] == null) {
            cities[index] = new City(name);
            return cities[index];
        }
        while (cities[index] != null) {
            if (cities[index].getName().equals(name)) {
                return cities[index];
            }
            index++;
        }
        return cities[index];
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % 541) + name.charAt(i);
        }
        return hash % 541;
    }

    /**
     * @return the cities
     */
    public City[] getCities() {
        return cities;
    }

}
