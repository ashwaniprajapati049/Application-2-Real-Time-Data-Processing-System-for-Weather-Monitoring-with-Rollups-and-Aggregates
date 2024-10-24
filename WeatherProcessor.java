import java.util.*;
import com.google.gson.Gson;

public class WeatherProcessor {

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static Map<String, Object> processWeatherData(String jsonData) {
        Gson gson = new Gson();
        Map<String, Object> weatherMap = gson.fromJson(jsonData, Map.class);
        double tempInKelvin = (Double) ((Map) weatherMap.get("main")).get("temp");
        double tempInCelsius = kelvinToCelsius(tempInKelvin);
        weatherMap.put("temp_celsius", tempInCelsius);
        return weatherMap;
    }

    public static void calculateDailySummary(List<Map<String, Object>> weatherData) {
        double sumTemp = 0;
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        int count = weatherData.size();

        for (Map<String, Object> data : weatherData) {
            double temp = (double) data.get("temp_celsius");
            sumTemp += temp;
            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
        }

        System.out.println("Average Temp: " + (sumTemp / count));
        System.out.println("Max Temp: " + maxTemp);
        System.out.println("Min Temp: " + minTemp);
    }

    public static void checkAlertThreshold(Map<String, Object> data, double threshold) {
        double temp = (double) data.get("temp_celsius");
        if (temp > threshold) {
            System.out.println("Alert! Temperature exceeds threshold: " + temp);
        }
    }
}
