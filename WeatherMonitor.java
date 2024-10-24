import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WeatherMonitor {
    private static final String API_KEY = "your_api_key";
    private static final String[] CITIES = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

    public static String getWeatherData(String city) throws Exception {
        String urlString = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, API_KEY);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
