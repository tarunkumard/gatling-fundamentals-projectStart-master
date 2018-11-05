package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt


import baseConfig.BaseSimulation

class AddPauseTime extends BaseSimulation{

  val scn = scenario(scenarioName = "Video Game DB")

    .exec(http(requestName = "Get All Video Games - 1st call")
      .get("videogames"))
    .pause(duration = 5)

    .exec(http(requestName = "Get specific game")
      .get("videogames/1"))
    .pause(1,20)

    .exec(http(requestName = "Get All Video Games - 2nd call ")
      .get("videogames"))
    .pause(duration = 3000.milliseconds)

  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpConf)
}
