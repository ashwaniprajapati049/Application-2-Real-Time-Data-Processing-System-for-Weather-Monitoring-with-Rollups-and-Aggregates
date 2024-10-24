# Application-2-Real-Time-Weather-Monitoring-System-
Here's the README.md file content specifically for Application 2: Real-Time Weather Monitoring System:

Real-Time Weather Monitoring System
Description
This application monitors real-time weather conditions for various Indian metros (Delhi, Mumbai, Chennai, Bangalore, Kolkata, Hyderabad) using the OpenWeatherMap API. It continuously retrieves data at regular intervals, processes the data (such as converting temperature from Kelvin to Celsius), and generates daily summaries with rollups and aggregates. The system also includes an alerting mechanism based on user-defined thresholds.

Features
Real-Time Data Retrieval: Fetches weather data for specific cities in India using the OpenWeatherMap API.
Temperature Conversion: Converts temperatures from Kelvin to Celsius.
Daily Rollups and Aggregates:
Average, minimum, and maximum temperature.
Dominant weather condition.
Alerting System: Configurable temperature thresholds trigger alerts if exceeded.
Extendable: Can support additional weather parameters (e.g., humidity, wind speed) and functionalities like weather forecasts.
How to Run the Application
Prerequisites:
1.Java: Ensure you have Java 8 or higher installed.
2.API Key: Obtain a free API key from OpenWeatherMap.
Setup Instructions:
1.Clone this repository:
git clone https://github.com/yourusername/weather-monitoring-system.git
cd weather-monitoring-system
2.Replace "your_api_key" in the WeatherMonitor.java file with your actual API key from OpenWeatherMap:
private static final String API_KEY = "your_api_key";
3.Compile and run the project:
javac WeatherMonitor.java WeatherProcessor.java WeatherMonitorTest.java
java WeatherMonitorTest
API Endpoints
1. GET /weather:
Description: Retrieves the current weather data for the specified cities.
Response:
{
  "city": "Delhi",
  "temp_celsius": 28.5,
  "weather_condition": "Clear"
}

2.POST /alert:
Description: Sets a user-configurable temperature threshold and triggers alerts if the temperature exceeds the defined limit.

Request Body:
{
  "threshold": 35.0
}
Response:
{
  "message": "Alert triggered! Temperature exceeded 35°C."
}
Testing
Test Case 1: Data Retrieval
The system should correctly fetch data from OpenWeatherMap API for the listed cities every 5 minutes.
Test Case 2: Temperature Conversion
Verify the conversion of temperature from Kelvin to Celsius using the provided formula.
Test Case 3: Daily Summary
Simulate a series of weather updates and verify that the average, minimum, and maximum temperatures are calculated correctly.
Test Case 4: Threshold Alerting
Set a threshold (e.g., 35°C) and test if the system triggers an alert when the temperature exceeds this threshold.
Extending the System
Additional Parameters: Extend the system to include humidity, wind speed, and other weather-related data.
Weather Forecasts: Integrate OpenWeatherMap’s weather forecast data to make predictions about future conditions.
Visualization: Implement basic visualizations to display trends or alert thresholds.
Dependencies
This project uses the following libraries:

Gson (for JSON parsing)
You can add it using Maven
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.8</version>
</dependency>
Conclusion
This application efficiently monitors weather data and alerts users to any temperature threshold breaches. You can customize the cities, data intervals, and threshold configurations to suit your use case.








