package com.trymad.weather_app.model.entity;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trymad.weather_app.model.mapper.json.deserializer.WeatherDataDeserializer;

import lombok.Data;

@Data
@JsonDeserialize(using = WeatherDataDeserializer.class)
public class WeatherData {

  private Location location;
  private CurrentWeather currentWeather;
  private List<Forecast> forecastList;

  public boolean containLocation() {
    return location != null;
  }

  public boolean containCurrentWeather() {
    return currentWeather != null;
  }

  public boolean containForecastList() {
    return !forecastList.isEmpty();
  }
}
