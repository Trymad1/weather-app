package com.trymad.weather_app.model.loader;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.trymad.weather_app.model.entity.WeatherData;

@Component
public class ApiWeatherLoader implements WeatherLoader {

  private final RestClient restClient;

  public ApiWeatherLoader(Environment env) {
    this.restClient = RestClient.builder()
        .baseUrl(env.getProperty("application.api.url"))
        .build();
  }

  @Override
  public WeatherData getWeatherByCityName(String cityName) {
    return null;
  }

}
