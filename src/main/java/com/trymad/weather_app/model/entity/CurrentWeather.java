package com.trymad.weather_app.model.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

  private Condition condition;
  private long last_updated_epoch;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime last_updated;

  private float temp_c;
  private float temp_f;

  @JsonProperty("is_day")
  private boolean isDay;
  private float wind_mph;
  private float wind_kph;
  private int wind_degree;
  private String wind_dir;
  private float pressure_mb;
  private float pressure_in;
  private float precip_mm;
  private float precip_in;
  private int humidity;
  private int cloud;
  private float feelslike_c;
  private float feelslike_f;
  private float windchill_c;
  private float windchill_f;
  private float heatindex_c;
  private float heatindex_f;
  private float dewpoint_c;
  private float dewpoint_f;
  private float vis_km;
  private float vis_miles;
  private float uv;
  private float gust_mph;
  private float gust_kph;

}
