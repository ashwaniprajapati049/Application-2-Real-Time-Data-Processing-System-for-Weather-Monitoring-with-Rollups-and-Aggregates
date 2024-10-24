public class WeatherMonitorTest {
    public static void main(String[] args) throws Exception {
        WeatherMonitor weatherMonitor = new WeatherMonitor();
        String weatherData = weatherMonitor.getWeatherData("Delhi");
        System.out.println("Weather Data: " + weatherData);

        WeatherProcessor processor = new WeatherProcessor();
        Map<String, Object> processedData = processor.processWeatherData(weatherData);
        System.out.println("Processed Data: " + processedData);

        List<Map<String, Object>> weatherList = new ArrayList<>();
        weatherList.add(processedData);
        processor.calculateDailySummary(weatherList);
        processor.checkAlertThreshold(processedData, 35.0);
    }
}
