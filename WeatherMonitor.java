import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WeatherMonitor {
    private static final String API_KEY = "your_api_key"; // Replace with your actual API key
    private static final String[] CITIES = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

    /**
     * Fetches the current weather data for the specified city.
     *
     * @param city The name of the city to retrieve weather data for.
     * @return A JSON string containing the weather data.
     * @throws Exception if there is an error during the API request.
     */
    public static String getWeatherData(String city) throws Exception {
        // Construct the API request URL
        String urlString = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, API_KEY);
        URL url = new URL(urlString);
        
        // Open connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        
        // Check for successful response code
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;
        
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        
        return content.toString(); // Return the weather data as a JSON string
    }
    
    public static void main(String[] args) {
        for (String city : CITIES) {
            try {
                String weatherData = getWeatherData(city);
                System.out.println("Weather data for " + city + ": " + weatherData);
            } catch (Exception e) {
                System.err.println("Error fetching weather data for " + city + ": " + e.getMessage());
            }
        }
    }
}
