package org.sebastiansiarczynski;

import static spark.Spark.*;

import org.sebastiansiarczynski.weather.controller.WeatherController;
import org.sebastiansiarczynski.weather.interceptor.WeatherInterceptor;
import org.sebastiansiarczynski.weather.service.WeatherService;

public class Main {

  public static void main(String[] args) {
    port(8081);

    final WeatherInterceptor weatherInterceptor = new WeatherInterceptor();
    final WeatherController weatherController = new WeatherController(new WeatherService());

    path("/weather", () -> {
      weatherInterceptor.weatherFilter();
      weatherController.init();
    });

    notFound((req, res) -> {
      res.type("application/json");
      return "{\"message\":\"Custom 404\"}";
    });
  }
}