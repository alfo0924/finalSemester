import java.io.*;
import java.util.*;

public class RestaurantMap {
    private Map<String, List<Restaurant>> restaurants;

    public RestaurantMap() {
        this.restaurants = new HashMap<>();
    }

    public void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 11) { // Ensure all required fields are present
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String description = data[2].trim();
                    String address = data[3].trim();
                    String zipCode = data[4].trim();
                    String region = data[5].trim();
                    String town = data[6].trim();
                    String tel = data[7].trim();
                    double pointX = Double.parseDouble(data[8].trim());
                    double pointY = Double.parseDouble(data[9].trim());
                    int rstClass = Integer.parseInt(data[10].trim());

                    if (rstClass != 0) { // Ignore if rstClass is 0
                        Restaurant restaurant = new Restaurant(id, name, description, address, zipCode,
                                region, town, tel, pointX, pointY, rstClass);

                        // Add restaurant to map based on region
                        restaurants.computeIfAbsent(region, k -> new ArrayList<>()).add(restaurant);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void save(String region) {
        if (!restaurants.containsKey(region)) {
            System.out.println("No restaurants found for region: " + region);
            return;
        }

        List<Restaurant> restaurantList = restaurants.get(region);

        // Sort restaurants by rstClass (descending)
        restaurantList.sort(Comparator.comparingInt(Restaurant::getRstClass).reversed());

        String fileName = region + ".csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Write CSV header
            writer.println("Name,Description,Add,Zipcode,Region,Town,Tel,Px,Py,Class");

            // Write each restaurant's data
            for (Restaurant restaurant : restaurantList) {
                writer.printf("%s,%s,%s,%s,%s,%s,%s,%.6f,%.6f,%d\n",
                        restaurant.getName(), restaurant.getDescription(), restaurant.getAddress(),
                        restaurant.getZipCode(), restaurant.getRegion(), restaurant.getTown(),
                        restaurant.getTel(), restaurant.getPointX(), restaurant.getPointY(),
                        restaurant.getRstClass());
            }

            System.out.println("Saved restaurants for region " + region + " to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printNearestRestaurants(String region, double pointX, double pointY) {
        if (!restaurants.containsKey(region)) {
            System.out.println("No restaurants found for region: " + region);
            return;
        }

        List<Restaurant> restaurantList = restaurants.get(region);

        // Calculate distances and sort by nearest to farthest
        restaurantList.sort(Comparator.comparingDouble(r ->
                calculateDistance(pointX, pointY, r.getPointX(), r.getPointY())));

        // Print nearest 3 restaurants
        System.out.println("Nearest restaurants in " + region + ":");
        int count = 0;
        for (Restaurant restaurant : restaurantList) {
            if (count >= 3) break;
            double distance = calculateDistance(pointX, pointY, restaurant.getPointX(), restaurant.getPointY());
            System.out.printf("%s, %s, %s, %.2f km\n", restaurant.getName(), restaurant.getAddress(),
                    restaurant.getTel(), distance);
            count++;
        }
    }

    private double calculateDistance(double x1, double y1, double x2, double y2) {
        // Implement distance calculation (e.g., Haversine formula)
        // For brevity, a placeholder return is provided
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
