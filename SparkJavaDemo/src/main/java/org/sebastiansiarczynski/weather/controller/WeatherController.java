package org.sebastiansiarczynski.weather.controller;

import static spark.Spark.get;
import org.sebastiansiarczynski.weather.service.WeatherService;

public class WeatherController {

  private final WeatherService weatherService;

  public WeatherController(final WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  public void init() {
    get("/country/:country", (req, res) -> {
      return res;
    });
  }
}
