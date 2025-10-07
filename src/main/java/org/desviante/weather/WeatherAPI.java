package org.desviante.weather;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class WeatherAPI {
    private static final String API_KEY;
    private static final String API_URL;
    
    static {
        Properties props = new Properties();
        String apiKey = "default_key";
        String apiUrl = "http://api.openweathermap.org/data/2.5/forecast?";
        
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            apiKey = props.getProperty("weather.api.key");
            apiUrl = props.getProperty("weather.api.url");
        } catch (IOException e) {
            System.err.println("Erro ao carregar config.properties: " + e.getMessage());
            System.err.println("Certifique-se de que o arquivo config.properties existe na raiz do projeto.");
        }
        
        API_KEY = apiKey;
        API_URL = apiUrl;
    }
    
    public static String getApiKey() {
        return API_KEY;
    }
    
    public static String getApiUrl() {
        return API_URL;
    }

    public static String getForecast(String city) throws IOException {
        try {
            // Constrói a URL completa (API_URL já tem '?' no final)
            String apiUrl = API_URL + "q=" + URLEncoder.encode(city, StandardCharsets.UTF_8) + "&appid=" + API_KEY + "&units=metric";
            URI uri = new URI(apiUrl);
            URL url = uri.toURL();
            
            // Usa try-with-resources para fechar recursos automaticamente
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                
                StringBuilder response = new StringBuilder();
                String line;
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                
                return response.toString();
            } finally {
                connection.disconnect();
            }
        } catch (URISyntaxException e) {
            throw new IOException("URL inválida: " + e.getMessage(), e);
        }
    }
}
