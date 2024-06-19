package com.trymad.weather_app.model.service.localizer;

import java.util.Optional;

import com.trymad.weather_app.model.entity.LocalizedCondition;

public interface LocalizedConditionStorage {
  public Optional<LocalizedCondition> getLocalizedCondition(int code, String lang);
}
