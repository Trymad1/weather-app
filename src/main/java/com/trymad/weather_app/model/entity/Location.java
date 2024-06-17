package com.trymad.weather_app.model.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime localtime;

}
