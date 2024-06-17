package com.trymad.weather_app.model;

import java.util.Date;

import lombok.Data;

@Data
public class Forecast {
  private Date date;
  private long date_epoch;
  private float maxtemp_c;
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
  private Condition condition;
  private float uv;
}
