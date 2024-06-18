package com.trymad.weather_app.model.mapper.json.deserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trymad.weather_app.model.entity.CurrentWeather;
import com.trymad.weather_app.model.entity.Forecast;
import com.trymad.weather_app.model.entity.Location;
import com.trymad.weather_app.model.entity.WeatherData;

public class WeatherDataDeserializer extends JsonDeserializer<WeatherData> {

  @Override
  public WeatherData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

    final ObjectMapper mapper = (ObjectMapper) p.getCodec();
    final JsonNode root = mapper.readTree(p);
    mapper.registerModule(new JavaTimeModule());
    final WeatherData weatherData = new WeatherData();

    if (root.has("current")) {
      final JsonNode currentNode = root.path("current");
      final CurrentWeather weather = mapper.treeToValue(currentNode, CurrentWeather.class);
      weatherData.setCurrentWeather(weather);

    }

    if (root.has("location")) {
      final JsonNode locationNode = root.path("location");
      checkLocalDateValidity(mapper, locationNode);
      final Location location = mapper.treeToValue(locationNode, Location.class);
      weatherData.setLocation(location);
    }

    if (root.has("forecast")) {
      final JsonNode forecastNode = root.path("forecast").path("forecastday");
      final List<Forecast> forecastList = getForecastList(forecastNode, mapper);
      weatherData.setForecastList(forecastList);
    }

    return weatherData;

  }

  private List<Forecast> getForecastList(JsonNode forecastNode, ObjectMapper mapper)
      throws JsonProcessingException, IllegalArgumentException {
    final List<Forecast> forecastList = new ArrayList<>();

    for (JsonNode curr : forecastNode) {
      JsonNode day = curr.path("day");
      final Forecast forecast = mapper.treeToValue(day, Forecast.class);
      forecast.setDate(LocalDate.parse(curr.get("date").asText()));
      forecast.setDate_epoch(curr.get("date_epoch").asLong());
      final List<CurrentWeather> hoursList = getHoursList(curr, mapper);
      forecast.setHours(hoursList);

      forecastList.add(forecast);
    }

    return forecastList;
  }

  private List<CurrentWeather> getHoursList(JsonNode curr, ObjectMapper mapper)
      throws JsonProcessingException, IllegalArgumentException {
    final List<CurrentWeather> hoursList = new ArrayList<>();

    for (JsonNode hour : curr.get("hour")) {
      final CurrentWeather currentWeather = mapper.treeToValue(hour,
          CurrentWeather.class);

      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      currentWeather.setLast_updated(LocalDateTime.parse(hour.get("time").asText(), formatter));
      currentWeather.setLast_updated_epoch(hour.get("time_epoch").asLong());
      hoursList.add(currentWeather);
    }

    return hoursList;
  }

  // I would like to apologize for this crutch, but it is necessary,
  // because for some reason the API returns the date in the H:mm format
  // when the time is 00:00, and you have to manually adjust the value to the
  // desired format
  private void checkLocalDateValidity(ObjectMapper mapper, JsonNode node) throws JsonProcessingException {
    String data = node.get("localtime").asText();
    if (data.length() < 16) {
      String date = data.substring(0, 11);
      String time = data.substring(11, data.length());
      String newData = date + "0" + time;

      ObjectNode objectNode = (ObjectNode) node;
      objectNode.put("localtime", newData);
      mapper.writeValueAsString(node);
    }
  }

}
