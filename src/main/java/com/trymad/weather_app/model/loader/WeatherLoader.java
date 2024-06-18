package com.trymad.weather_app.model.loader;

import java.time.LocalDate;

import com.trymad.weather_app.model.entity.WeatherData;

public interface WeatherLoader {

  WeatherData getForecastDataByCityName(String cityName, int days, boolean aqi, boolean alerts);

  WeatherData getHistoryDataByCityName(String cityName, LocalDate date);
}
