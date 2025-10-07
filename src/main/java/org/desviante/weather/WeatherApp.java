package org.desviante.weather;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        System.out.println("Weather App");
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What city you would like to see the weather forecast for?: ");
            // String city = "Detroit"; //first test
            String city = scanner.nextLine();
            WeatherResponseParser parser = new WeatherResponseParser();
            
            String forecastString = WeatherAPI.getForecast(city);
            parser.parseAndPrint(forecastString);
        } catch (IOException e) {
            System.err.println("Erro ao buscar previsão: " + e.getMessage());
        }
    }
}
