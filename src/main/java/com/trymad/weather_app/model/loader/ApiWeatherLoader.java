package com.trymad.weather_app.model.loader;

import java.time.LocalDate;

import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.trymad.weather_app.model.entity.WeatherData;

@Component
public class ApiWeatherLoader implements WeatherLoader {

  private final RestClient restClient;
  private final String apiKey;

  private final MediaType DATA_FORMAT;
  private final String FORECAST_QUERY_TEMPLATE = "forecast.%s?key=%s&q=%s&days=%d&aqi=%s&alerts=%s";
  private final String HISTORY_QUERY_TEMPLATE = "history.%s?key=%s&q=%s&dt=%s";

  public ApiWeatherLoader(Environment env) {
    this.apiKey = env.getProperty("application.api.key");
    this.DATA_FORMAT = getFileFormat(env.getProperty("application.api.data_format"));
    this.restClient = RestClient.builder()
        .baseUrl(env.getProperty("application.api.url"))
        .build();
  }

  @Override
  public WeatherData getForecastDataByCityName(String cityName, int days, boolean aqi, boolean alerts) {
    WeatherData weatherData = null;
    try {
      final WeatherData response = restClient.get()
      .uri(generateForecastParamRequest(cityName, days, aqi, alerts))
      .accept(DATA_FORMAT)
      .retrieve()
      .body(WeatherData.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return weatherData;
  }

  @Override
  public WeatherData getHistoryDataByCityName(String cityName, LocalDate date) {
    WeatherData weatherData = null;

    try {
      weatherData = restClient.get()
      .uri(generateHistoryParamRequest(cityName, date))
      .accept(DATA_FORMAT)
      .retrieve()
      .body(WeatherData.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return weatherData;
  }

  private MediaType getFileFormat(String fileFormat) {
    if (fileFormat.toLowerCase().equals("json")) {
      return MediaType.APPLICATION_JSON;
    } else {
      return MediaType.APPLICATION_XML;
    }
  }

  private String generateForecastParamRequest(String cityName, int days, boolean aqi, boolean alerts) {
    final String aqiStr = aqi ? "yes" : "no";
    final String alertsStr = alerts ? "yes" : "no";
    return String.format(
        FORECAST_QUERY_TEMPLATE, DATA_FORMAT.getSubtype(), apiKey, cityName, days, aqiStr, alertsStr);
  }

  private final String generateHistoryParamRequest(String cityName, LocalDate date) {
    return String.format(
        HISTORY_QUERY_TEMPLATE, DATA_FORMAT.getSubtype(), apiKey, cityName, date.toString());
  }
}
