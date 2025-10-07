package org.desviante.weather;

import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherResponseParser {
    public void parseAndPrint(String response){
        JSONObject jsonResponse = new JSONObject(response);

        if (jsonResponse.getInt("cod") == 200){
            System.out.println("Weather forecast for city: " + jsonResponse.getJSONObject("city").getString("name"));
            JSONArray list = jsonResponse.getJSONArray("list");
            
            for (int i = 0; i < list.length(); i++){
                JSONObject forecast = list.getJSONObject(i);
                long timestamp = forecast.getLong("dt");
                String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(timestamp * 1000));
                double temperature = forecast.getJSONObject("main").getDouble("temp");
                int humidity = forecast.getJSONObject("main").getInt("humidity");
                String description = forecast.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.println("Date: " + date);
                System.out.println("Temperature: " + temperature + "°C");
                System.out.println("Humidity: " + humidity + "%");
                System.out.println("Description: " + description);
                System.out.println("--------------------------------");
            }
        } else {
            System.out.println("Request contains an error: " + jsonResponse.getString("message"));
        }
    }
}
