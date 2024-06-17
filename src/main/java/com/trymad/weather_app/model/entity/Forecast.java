package com.trymad.weather_app.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

  private Condition condition;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate date;

  private long date_epoch;
  private double maxtemp_c;
  private float maxtemp_f;
  private float mintemp_f;
  private float avgtemp_c;
  private float avgtemp_f;
  private float maxwind_mph;
  private float maxwind_kph;
  private float totalprecip_mm;
  private float totalprecip_in;
  private float totalsnow_cm;
  private float avgvis_km;
  private float avgvis_miles;
  private int avghumidity;
  private boolean dailyWillItRain;
  private int dailyChanceOfRain;
  private boolean dailyWillItSnow;
  private boolean dailyChanceOfSnow;
  private float uv;
  List<CurrentWeather> hours;
}
