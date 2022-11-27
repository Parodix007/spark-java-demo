package org.sebastiansiarczynski;

import static spark.Spark.*;

public class Main {

  public static void main(String[] args) {
    port(8081);

    get("/test", (req, res) -> "Hello Spark");
    get("/test/:var", (req, res) -> {
      System.out.println(req.headers());
      return req.params();
    });
  }
}