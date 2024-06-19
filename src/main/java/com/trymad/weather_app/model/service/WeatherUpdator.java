package com.trymad.weather_app.model.service;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.swing.ImageIcon;

import org.springframework.core.io.ClassPathResource;
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
    frame.getWeatherImageLabel1().setIcon(getImageIcon(currentWeather.getCondition().getIcon()));

    setForecastData(currentForecast);

  }

  // TODO hardcode forecast need fix
  private void setForecastData(List<Forecast> forecast) {
    Map<Integer, String> ruWeekendShortNames = Map.of(
        1, "Пн",
        2, "Вт",
        3, "Ср",
        4, "Чт",
        5, "Пт",
        6, "Сб",
        7, "Вс");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM", new Locale("ru"));

    Forecast forecastDay1 = forecast.get(0);
    frame.getForecastImageDay1().setIcon(getImageIcon(forecastDay1.getCondition().getIcon()));
    frame.getForecastFeelTemperatureDay1().setText(getTemperature(forecastDay1.getAvgtemp_c()));
    frame.getForecastTemperatureDay1().setText(getTemperature(forecastDay1.getAvgtemp_c()));
    frame.getForecastConditionDay1().setText(forecastDay1.getCondition().getText());
    frame.getForecastWeekendDay1().setText(ruWeekendShortNames.get(forecastDay1.getDate().getDayOfWeek().getValue()));
    frame.getForecastDateDay1().setText(forecastDay1.getDate().format(formatter));

    Forecast forecastDay2 = forecast.get(1);
    frame.getForecastImageDay2().setIcon(getImageIcon(forecastDay2.getCondition().getIcon()));
    frame.getForecastFeelTemperatureDay2().setText(getTemperature(forecastDay2.getAvgtemp_c()));
    frame.getForecastTemperatureDay2().setText(getTemperature(forecastDay2.getAvgtemp_c()));
    frame.getForecastConditionDay2().setText(forecastDay2.getCondition().getText());
    frame.getForecastWeekendDay2().setText(ruWeekendShortNames.get(forecastDay2.getDate().getDayOfWeek().getValue()));
    frame.getForecastDateDay2().setText(forecastDay2.getDate().format(formatter));

    Forecast forecastDay3 = forecast.get(2);
    frame.getForecastImageDay3().setIcon(getImageIcon(forecastDay3.getCondition().getIcon()));
    frame.getForecastFeelTemperatureDay3().setText(getTemperature(forecastDay3.getAvgtemp_c()));
    frame.getForecastTemperatureDay3().setText(getTemperature(forecastDay3.getAvgtemp_c()));
    frame.getForecastCondititonDay3().setText(forecastDay3.getCondition().getText());
    frame.getForecastWeekendDay3().setText(ruWeekendShortNames.get(forecastDay3.getDate().getDayOfWeek().getValue()));
    frame.getForecastDateDay3().setText(forecastDay3.getDate().format(formatter));
  }

  // TODO fix this trash
  private ImageIcon getImageIcon(String iconPath) {
    try {
      Image image = imageLoader.loadImage(new URL(URL_PROTOCOL + iconPath));
      if (image == null)
        return new ImageIcon(new ClassPathResource("static/image/not_found.png").getURL());
      return new ImageIcon(image);
    } catch (IOException e) {
      e.printStackTrace();
      try {
        return new ImageIcon(new ClassPathResource("static/image/not_found.png").getURL());
      } catch (IOException e1) {
        e1.printStackTrace();
        return null;
      }
    }
  }

  private String getTemperature(float temp) {
    String prefix = (int) temp < 0 ? "-" : "+";
    return prefix + String.valueOf((int) temp) + "°";
  }

}
