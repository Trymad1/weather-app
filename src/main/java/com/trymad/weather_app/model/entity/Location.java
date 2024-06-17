package com.trymad.weather_app.model.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Location {

  private String name;
  private String region;
  private String country;
  private float lat;
  private float lon;
  private String tz_id;
  private long localtime_epoch;
  private LocalDateTime localTime;
  
}
