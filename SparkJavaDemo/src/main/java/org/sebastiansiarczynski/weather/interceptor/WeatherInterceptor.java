package org.sebastiansiarczynski.weather.interceptor;

import static spark.Spark.before;
import static spark.Spark.halt;

public class WeatherInterceptor {

  private final static String WEATHER_TOKEN_HEADER_NAME = "X-OpenWeather-Token";

  public void weatherFilter() {
    before("/*", (req, res) -> {
      String headers = req.headers(WEATHER_TOKEN_HEADER_NAME);

      if (headers == null || headers.isBlank()) {
        halt(400, "CANNOT FIND WEATHER TOKEN HEADER!");
      }
    });
  }
}
