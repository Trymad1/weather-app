package com.trymad.weather_app.model.loader;

import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.trymad.weather_app.model.entity.WeatherData;

@Component
public class ApiWeatherLoader implements WeatherLoader {

  private final RestClient restClient;
  private final String apiKey;
  private final String PARAM_TEMPLATE = "?key=%s&q=%s&days=%d&aqi=%s&alerts=%s";

  public ApiWeatherLoader(Environment env) {
    this.apiKey = env.getProperty("application.api.key");
    this.restClient = RestClient.builder()
        .baseUrl(getApiUrl(env))
        .build();
  }

  @Override
  public WeatherData getWeatherByCityName(String cityName) {
    final WeatherData response = restClient.get()
        .uri(generateForecastParamRequest(cityName, 3, false, false))
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .body(WeatherData.class);

    return response;
  }

  private String getApiUrl(Environment env) {
    return env.getProperty("application.api.url")
        + "forecast."
        + env.getProperty("application.api.data_format");
  }

  private String generateForecastParamRequest(String cityName, int days, boolean aqi, boolean alerts) {
    final String aqiStr = aqi ? "yes" : "no";
    final String alertsStr = alerts ? "yes" : "no";
    return String.format(PARAM_TEMPLATE, apiKey, cityName, days, aqiStr, alertsStr);
  }
}
