package com.trymad.weather_app.model.service.localizer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.trymad.weather_app.model.entity.Condition;
import com.trymad.weather_app.model.entity.CurrentWeather;
import com.trymad.weather_app.model.entity.Forecast;
import com.trymad.weather_app.model.entity.LocalizedCondition;
import com.trymad.weather_app.model.entity.WeatherData;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LocalizerImpl implements Localizer {

  private final LocalizedConditionStorage localizedConditionStorage;

  @Override
  public LocalizedCondition getLocalizedCondition(int code, String lang) {
    Optional<LocalizedCondition> optionaLocalizedCondition = localizedConditionStorage
        .getLocalizedCondition(code, lang);

    return optionaLocalizedCondition.orElseThrow();
  }

  @Override
  public void localizeWeatherData(WeatherData data, String lang_iso) {
    if (data.containCurrentWeather()) {
      final CurrentWeather currentWeather = data.getCurrentWeather();
      setLocalizeToCondition(currentWeather.getCondition(), lang_iso, currentWeather.isDay());
    }

    if (data.containForecastList()) {
      final List<Forecast> forecastList = data.getForecastList();
      forecastList.forEach(forecast -> setLocalizeToForecast(forecast, lang_iso));
    }
  }

  private void setLocalizeToForecast(Forecast forecast, String lang_iso) {
    final Condition currCondition = forecast.getCondition();
    setLocalizeToCondition(currCondition, lang_iso, true);
    forecast.getHours().forEach(hour -> {
      setLocalizeToCondition(hour.getCondition(), lang_iso, hour.isDay());
    });
  }

  private void setLocalizeToCondition(Condition currCondition, String lang_iso, boolean isDay) {
    final LocalizedCondition currLocalizedCondition = getLocalizedCondition(
        currCondition.getCode(), lang_iso);

    currCondition.setText(
        getNightOrDayConditionText(currLocalizedCondition, isDay));
  }

  private String getNightOrDayConditionText(LocalizedCondition lc, boolean isDay) {
    return isDay ? lc.getDay_text() : lc.getNight_text();
  }
}
