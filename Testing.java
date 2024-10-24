import java.util.*;

public class WeatherMonitorTest {
    public static void main(String[] args) {
        try {
            // Create an instance of WeatherMonitor to fetch weather data
            WeatherMonitor weatherMonitor = new WeatherMonitor();
            String weatherData = weatherMonitor.getWeatherData("Delhi");
            System.out.println("Weather Data: " + weatherData);

            // Process the retrieved weather data
            WeatherProcessor processor = new WeatherProcessor();
            Map<String, Object> processedData = processor.processWeatherData(weatherData);
            System.out.println("Processed Data: " + processedData);

            // Create a list to hold weather data for daily summary calculations
            List<Map<String, Object>> weatherList = new ArrayList<>();
            weatherList.add(processedData);

            // Calculate and print daily weather summary
            processor.calculateDailySummary(weatherList);
            
            // Check if the temperature exceeds the alert threshold
            processor.checkAlertThreshold(processedData, 35.0);
        } catch (Exception e) {
            // Print an error message if an exception occurs
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
