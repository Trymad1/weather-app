package com.trymad.weather_app.model.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;

import org.springframework.stereotype.Component;

import com.trymad.weather_app.model.entity.CurrentWeather;
import com.trymad.weather_app.model.entity.Forecast;
import com.trymad.weather_app.model.entity.Location;
import com.trymad.weather_app.model.entity.WeatherData;
import com.trymad.weather_app.model.loader.ImageLoader;
import com.trymad.weather_app.model.service.localizer.Localizer;
import com.trymad.weather_app.ui.MainFrame;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WeatherUpdator {

  private final static int DAYS_FOR_FORECAST = 3;
  private final static boolean AQI = false;
  private final static boolean ALERTS = false;
  private final static String DEFAULT_LANGUAGE_ISO = "ru";
  private final static String URL_PROTOCOL = "http:";

  private final MainFrame frame;
  private final WeatherDataService weatherDataService;
  private final Localizer localizer;
  private final ImageLoader imageLoader;

  private WeatherData currentWeatherData;
  private WeatherData historyWeatherData;

  public void updateWeatherInformation(String city) {
    Optional<WeatherData> optionalData = weatherDataService.getForecastData(city, DAYS_FOR_FORECAST, AQI, ALERTS);
    if (optionalData.isEmpty()) {
      // TODO handling
      throw new IllegalAccessError("City not find");
    }

    currentWeatherData = optionalData.get();
    historyWeatherData = weatherDataService.getHistoryData(city, LocalDate.now().minusDays(1)).get();

    localizer.localizeWeatherData(currentWeatherData, DEFAULT_LANGUAGE_ISO);
    localizer.localizeWeatherData(historyWeatherData, DEFAULT_LANGUAGE_ISO);

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
    frame.getWeatherInfoLabel().setText(currentWeather.getCondition().getText());

    try {
      frame.getWeatherImageLabel1().setIcon(
          new ImageIcon(imageLoader.loadImage(new URL(URL_PROTOCOL + currentWeather.getCondition().getIcon()))));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  private String getTemperature(float temp) {
    String prefix = (int) temp < 0 ? "-" : "+";
    return prefix + String.valueOf((int) temp) + "°";
  }

}
