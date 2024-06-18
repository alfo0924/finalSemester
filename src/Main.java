import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // 下載餐廳信息的 CSV 文件
            String url = "https://media.taiwan.net.tw/XMLReleaseALL_public/Restaurant_C_f.csv";
            String fileName = "Restaurant_C_f.csv";
            downloadFile(url, fileName);

            // 創建 RestaurantMap 對象
            RestaurantMap restaurantMap = new RestaurantMap();

            // 從 CSV 文件加載數據
            restaurantMap.load(fileName);

            // 將數據保存到各地區的 CSV 文件中（示例）
            restaurantMap.save("臺中市");

            // 打印最近的餐廳
            double targetPointX = 120.649539; // 逢甲大學的坐標
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
