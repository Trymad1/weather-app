package com.trymad.weather_app.model.loader;

import com.trymad.weather_app.model.entity.WeatherData;

public interface WeatherLoader {

  WeatherData getWeatherByCityName(String cityName);

}
