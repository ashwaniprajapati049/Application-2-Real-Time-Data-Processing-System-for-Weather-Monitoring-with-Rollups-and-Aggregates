import java.util.*;
import com.google.gson.Gson;

public class WeatherProcessor {

    /**
     * Converts temperature from Kelvin to Celsius.
     *
     * @param kelvin The temperature in Kelvin.
     * @return The temperature in Celsius.
     */
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15; // Conversion formula
    }

    /**
     * Processes the weather data from a JSON string.
     *
     * @param jsonData The weather data in JSON format.
     * @return A map containing the processed weather data.
     */
    public static Map<String, Object> processWeatherData(String jsonData) {
        Gson gson = new Gson();
        Map<String, Object> weatherMap = gson.fromJson(jsonData, Map.class);
        
        // Extract temperature from the JSON data
        double tempInKelvin = (Double) ((Map) weatherMap.get("main")).get("temp");
        double tempInCelsius = kelvinToCelsius(tempInKelvin);
        
        // Add Celsius temperature to the map
        weatherMap.put("temp_celsius", tempInCelsius);
        return weatherMap;
    }

    /**
     * Calculates and prints the daily weather summary.
     *
     * @param weatherData A list of weather data maps.
     */
    public static void calculateDailySummary(List<Map<String, Object>> weatherData) {
        if (weatherData.isEmpty()) {
            System.out.println("No weather data available to summarize.");
            return;
        }

        double sumTemp = 0;
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        int count = weatherData.size();

        // Iterate through the weather data to calculate summary statistics
        for (Map<String, Object> data : weatherData) {
            double temp = (double) data.get("temp_celsius");
            sumTemp += temp;

            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
        }

        // Print the daily summary
        System.out.println("Average Temp: " + (sumTemp / count));
        System.out.println("Max Temp: " + maxTemp);
        System.out.println("Min Temp: " + minTemp);
    }

    /**
     * Checks if the temperature exceeds a specified alert threshold.
     *
     * @param data The weather data map containing the temperature.
     * @param threshold The temperature threshold for alerting.
     */
    public static void checkAlertThreshold(Map<String, Object> data, double threshold) {
        double temp = (double) data.get("temp_celsius");
        if (temp > threshold) {
            System.out.println("Alert! Temperature exceeds threshold: " + temp);
        }
    }
}
