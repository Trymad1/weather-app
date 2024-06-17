package com.trymad.weather_app.model.entity;

import java.util.List;

import lombok.Data;

@Data
public class WeatherData {

  private CurrentWeather currentWeather;
  private List<Forecast> forecastList;

}
