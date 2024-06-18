package com.trymad.weather_app.model.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.trymad.weather_app.model.entity.WeatherData;
import com.trymad.weather_app.model.loader.WeatherLoader;

@Service
public class WeatherDataService {

  private final WeatherLoader weatherLoader;

  public WeatherDataService(final WeatherLoader weatherLoader) {
    this.weatherLoader = weatherLoader;
  }

  public WeatherData getForecastData(String cityName, int days, boolean aqi, boolean alerts) {
    return weatherLoader.getForecastDataByCityName(cityName, days, aqi, alerts);
  }

  public WeatherData getHistoryData(String cityName, LocalDate date) {
    return weatherLoader.getHistoryDataByCityName(cityName, date);
  }
}
