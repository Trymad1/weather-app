package com.trymad.weather_app.model.service;

import org.springframework.stereotype.Service;

import com.trymad.weather_app.model.entity.WeatherData;
import com.trymad.weather_app.model.loader.WeatherLoader;

@Service
public class WeatherDataService {

  private final WeatherLoader weatherLoader;

  public WeatherDataService(final WeatherLoader weatherLoader) {
    this.weatherLoader = weatherLoader;
  }

  public WeatherData getData(String cityName) {
    return weatherLoader.getWeatherByCityName(cityName);
  }
}
