package com.trymad.weather_app.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.trymad.weather_app.model.entity.CurrentWeather;
import com.trymad.weather_app.model.entity.Forecast;
import com.trymad.weather_app.model.entity.Location;
import com.trymad.weather_app.model.entity.WeatherData;
import com.trymad.weather_app.ui.MainFrame;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WeatherUpdator {

  private final MainFrame frame;
  private final WeatherDataService weatherDataService;
  private WeatherData currentWeatherData;
  private WeatherData historyWeatherData;

  private final static int DAYS_FOR_FORECAST = 3;
  private final static boolean AQI = false;
  private final static boolean ALERTS = false;

  public void getWeatherInformation(String city) {
    Optional<WeatherData> optionalData = weatherDataService.getForecastData(city, DAYS_FOR_FORECAST, AQI, ALERTS);
    if (optionalData.isEmpty()) {
      // TODO handling
      throw new IllegalAccessError("City not find");
    }

    currentWeatherData = optionalData.get();
    historyWeatherData = weatherDataService.getHistoryData(city, LocalDate.now().minusDays(1)).get();
    setDataToView();

  }

  private void setDataToView() {
    final CurrentWeather currentWeather = this.currentWeatherData.getCurrentWeather();
    final Location currentLocation = currentWeatherData.getLocation();
    final List<Forecast> currentForecast = currentWeatherData.getForecastList();

    final Location historyLocation = historyWeatherData.getLocation();
    final List<Forecast> historyForecast = historyWeatherData.getForecastList();

    frame.getCityNameLabel().setText(currentLocation.getName());
    frame.getCityYesterdayTimeInfoLabel()
        .setText(String.format(frame.TIME_TEMPLATE, currentLocation.getLocaltime().toLocalTime().toString()));

    int indexForHours = currentLocation.getLocaltime().getHour();
    float yesterdayTemp = historyForecast.get(0).getHours().get(indexForHours).getTemp_c();
    frame.getCityYesterdayTemperatureLabel().setText(getTemperature(yesterdayTemp));

    frame.getTemperatureLabel().setText(getTemperature(currentWeather.getTemp_c()));
    frame.getTemperatureFeelsLabel().setText(getTemperature(currentWeather.getFeelslike_c()));
    frame.getWaterPercentsLabel().setText(currentWeather.getHumidity() + "%");
    frame.getWindInfoLabel().setText(currentWeather.getWind_mph() + " м/ч");
  }

  private String getTemperature(float temp) {
    String prefix = (int) temp < 0 ? "-" : "+";
    return prefix + String.valueOf((int) temp) + "°";
  }

}
