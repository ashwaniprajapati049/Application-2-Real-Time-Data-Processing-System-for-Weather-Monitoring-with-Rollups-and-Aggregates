# Real-Time Weather Monitoring System

## Description
This application monitors real-time weather conditions for various Indian metros (Delhi, Mumbai, Chennai, Bangalore, Kolkata, Hyderabad) using the [OpenWeatherMap API](https://openweathermap.org/api). It continuously retrieves data at regular intervals, processes the data (such as converting temperature from Kelvin to Celsius), and generates daily summaries with rollups and aggregates. The system also includes an alerting mechanism based on user-defined thresholds.

## Features
- **Real-Time Data Retrieval**: Fetches weather data for specific cities in India using the OpenWeatherMap API.
- **Temperature Conversion**: Converts temperatures from Kelvin to Celsius.
- **Daily Rollups and Aggregates**: Calculates average, minimum, and maximum temperatures, along with the dominant weather condition.
- **Alerting System**: Configurable temperature thresholds trigger alerts if exceeded.
- **Extendable**: Can support additional weather parameters (e.g., humidity, wind speed) and functionalities like weather forecasts.

## How to Run the Application

### Prerequisites
1. **Java**: Ensure you have Java 8 or higher installed.
2. **API Key**: Obtain a free API key from OpenWeatherMap.

### Setup Instructions
1. Clone this repository:
   bash
   git clone https://github.com/yourusername/weather-monitoring-system.git
   cd weather-monitoring-system
   Replace your_api_key in the WeatherMonitor.java file with your actual API key from OpenWeatherMap:
   private static final String API_KEY = "your_api_key";
Compile and run the project:
javac WeatherMonitor.java WeatherProcessor.java WeatherMonitorTest.java
java WeatherMonitorTest
API Endpoints
GET /weather
Description: Retrieves the current weather data for the specified cities.
Response
{
  "city": "Delhi",
  "temp_celsius": 28.5,
  "weather_condition": "Clear"
}
POST /alert
Description: Sets a user-configurable temperature threshold and triggers alerts if the temperature exceeds the defined limit.
Request Body:
{
  "threshold": 35.0
}
Response
{
  "message": "Alert triggered! Temperature exceeded 35°C."
}
Conclusion
This application efficiently monitors weather data and alerts users to any temperature threshold breaches. You can customize the cities, data intervals, and threshold configurations to suit your use case.

### Key Improvements:

1. **Headings and Structure**: Organized content under clear headings for easier navigation.
2. **Code Blocks**: Used code blocks for command-line instructions and JSON responses for better readability.
3. **Formatting Consistency**: Ensured consistent formatting throughout the document.
4. **Links**: Added a link to the OpenWeatherMap API for quick reference.

Feel free to copy this directly into your `README.md` file. Let me know if you need any more changes or further assistance!

