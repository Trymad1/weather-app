package com.trymad.weather_app.model.entity;

import lombok.Data;

@Data
public class LocalizedCondition {

  private String lang_name;
  private String lang_iso;
  private String day_text;
  private String night_text;

}
