package com.trymad.weather_app.presenter;

import java.awt.event.ActionEvent;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.trymad.weather_app.model.service.WeatherUpdator;

@Component
public class MainFramePresenterImpl implements MainFramePresenter {

  private final WeatherUpdator weatherUpdator;

  public MainFramePresenterImpl(@Lazy WeatherUpdator weatherUpdator) {
    this.weatherUpdator = weatherUpdator;
  }

  @Override
  public void searchButtonPressed(ActionEvent event) {

  }
}
