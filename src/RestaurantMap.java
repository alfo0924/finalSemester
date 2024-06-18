import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantMap {
    private List<Restaurant> restaurants;

    public RestaurantMap() {
        this.restaurants = new ArrayList<>();
    }

    public void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 17) {
                    String id = parts[0];
                    String name = parts[1];
                    String description = parts[2];
                    String address = parts[3];
                    String city = parts[4];
                    String county = parts[5];
                    String phone = parts[6];
                    List<String> openHours = parseOpenHours(parts[7]);
                    String imageUrl = parts[10];
                    String owner = parts[11];
                    String classType = parts[12];
                    double longitude = Double.parseDouble(parts[13]);
                    double latitude = Double.parseDouble(parts[14]);
                    String classDesc = parts[15];
                    int index = Integer.parseInt(parts[16]);

                    Restaurant restaurant = new Restaurant(id, name, description, address, city, county, phone,
                            openHours, imageUrl, owner, classType, longitude, latitude, classDesc, index);
                    restaurants.add(restaurant);
                } else {
                    System.out.println("Invalid data line: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private List<String> parseOpenHours(String hoursString) {
        List<String> openHours = new ArrayList<>();
        String[] hours = hoursString.split("；"); // 使用中文分號分隔多個時間段

        for (String hour : hours) {
            openHours.add(hour.trim()); // 去掉時間段內部空格
        }

        return openHours;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void save(String region) {
        String fileName = region + "_restaurants.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Restaurant restaurant : restaurants) {
                if (restaurant.getCity().equals(region)) {
                    writer.append(restaurant.getId()).append(",")
                            .append(restaurant.getName()).append(",")
                            .append(restaurant.getDescription()).append(",")
                            .append(restaurant.getAddress()).append(",")
                            .append(restaurant.getCity()).append(",")
                            .append(restaurant.getCounty()).append(",")
                            .append(restaurant.getPhone()).append(",")
                            .append(String.join("；", restaurant.getOpenHours())).append(",")
                            .append(restaurant.getImageUrl()).append(",")
                            .append(restaurant.getOwner()).append(",")
                            .append(restaurant.getClassType()).append(",")
                            .append(Double.toString(restaurant.getLongitude())).append(",")
                            .append(Double.toString(restaurant.getLatitude())).append(",")
                            .append(restaurant.getClassDesc()).append(",")
                            .append(Integer.toString(restaurant.getIndex())).append("\n");
                }
            }
            System.out.println("Saved restaurants in " + region + " to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printNearestRestaurants(String region, double targetX, double targetY) {
        // Implement your logic to find and print nearest restaurants
        // Example: find restaurants near coordinates (targetX, targetY) in specified region
    }
}
