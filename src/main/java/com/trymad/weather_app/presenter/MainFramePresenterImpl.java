package com.trymad.weather_app.presenter;

import java.awt.event.ActionEvent;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.trymad.weather_app.model.service.WeatherUpdator;

@Component
public class MainFramePresenterImpl implements MainFramePresenter {

  private final WeatherUpdator weatherUpdator;
  private String currentCity;

  public MainFramePresenterImpl(@Lazy WeatherUpdator weatherUpdator) {
    this.weatherUpdator = weatherUpdator;
    this.currentCity = "";
  }

  @Override
  public void searchButtonPressed(ActionEvent event, String cityName) {
    if (currentCity.equals(cityName))
      return;
    System.out.println("Fetch");
    currentCity = cityName;
    weatherUpdator.updateWeatherInformation(cityName);
  }
}
