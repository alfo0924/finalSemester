import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // Download the restaurant information CSV file
            String url = "https://media.taiwan.net.tw/XMLReleaseALL_public/Restaurant_C_f.csv";
            String fileName = "Restaurant_C_f.csv";
            downloadFile(url, fileName);

            // Create a RestaurantMap object
            RestaurantMap restaurantMap = new RestaurantMap();

            // Load data from CSV file
            restaurantMap.load(fileName);

            // Save data to CSV files for each region (example)
            restaurantMap.save("臺中市");

            // Print nearest restaurants
            double targetPointX = 120.649539; // Example coordinates (逢甲大學)
            double targetPointY = 24.179335;
            restaurantMap.printNearestRestaurants("臺中市", targetPointX, targetPointY);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadFile(String url, String fileName) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }
}
