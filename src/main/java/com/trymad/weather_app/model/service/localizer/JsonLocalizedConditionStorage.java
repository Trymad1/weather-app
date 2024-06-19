package com.trymad.weather_app.model.service.localizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trymad.weather_app.model.entity.LocalizedCondition;

@Component
public class JsonLocalizedConditionStorage implements LocalizedConditionStorage {

  private final Map<Integer, ArrayList<LocalizedCondition>> conditionMap;
  private final String PATH_TO_JSON = "static/conditions.json";
  private boolean isLoaded = false;

  public JsonLocalizedConditionStorage() {
    this.conditionMap = new HashMap<>();
    initStorage();
  }

  @Override
  public Optional<LocalizedCondition> getLocalizedCondition(int code, String lang) {
    if (!conditionMap.containsKey(code))
      return Optional.empty();
    final ArrayList<LocalizedCondition> conditions = conditionMap.get(code);
    return conditions.stream().filter(cond -> cond.getLang_iso().equals(lang)).findFirst();
  }

  public void initStorage() {
    if (isLoaded)
      return;
    try {
      loadConditionsFromJson(getJson(PATH_TO_JSON));
      isLoaded = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private JsonNode getJson(String resourcePath) throws IOException {
    ClassPathResource resource = new ClassPathResource(resourcePath);
    return new ObjectMapper().readTree(resource.getInputStream());
  }

  private void loadConditionsFromJson(JsonNode jsonNode) {
    final ObjectMapper mapper = new ObjectMapper();
    jsonNode.forEach(condition -> {

      final int code = condition.get("code").asInt();
      final ArrayList<LocalizedCondition> localizedList = new ArrayList<>();
      conditionMap.put(code, localizedList);

      condition.get("languages").forEach(localizedJson -> {
        try {
          LocalizedCondition localizedCondition = mapper.treeToValue(localizedJson, LocalizedCondition.class);
          localizedList.add(localizedCondition);
        } catch (JsonProcessingException | IllegalArgumentException e) {
          e.printStackTrace();
        }
      });
    });
  }

}
