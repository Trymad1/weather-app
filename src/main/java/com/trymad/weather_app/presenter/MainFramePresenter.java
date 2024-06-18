package com.trymad.weather_app.presenter;

import java.awt.event.ActionEvent;

public interface MainFramePresenter {
  void searchButtonPressed(ActionEvent event, String cityName);
}
