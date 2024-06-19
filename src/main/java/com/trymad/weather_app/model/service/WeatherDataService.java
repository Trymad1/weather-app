package com.trymad.weather_app.model.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trymad.weather_app.model.entity.WeatherData;
import com.trymad.weather_app.model.loader.WeatherLoader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherDataService {

  private final WeatherLoader weatherLoader;

  public Optional<WeatherData> getForecastData(String cityName, int days, boolean aqi, boolean alerts) {
    final WeatherData data = weatherLoader.getForecastDataByCityName(cityName, days, aqi, alerts);
    return Optional.ofNullable(data);
  }

  public Optional<WeatherData> getHistoryData(String cityName, LocalDate date) {
    final WeatherData data = weatherLoader.getHistoryDataByCityName(cityName, date);
    return Optional.ofNullable(data);
  }
}
