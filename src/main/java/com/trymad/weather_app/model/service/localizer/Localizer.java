package com.trymad.weather_app.model.service.localizer;

import com.trymad.weather_app.model.entity.LocalizedCondition;
import com.trymad.weather_app.model.entity.WeatherData;

public interface Localizer {

  LocalizedCondition getLocalizedCondition(int code, String langIso);

  void localizeWeatherData(WeatherData data, String langIso);

}
