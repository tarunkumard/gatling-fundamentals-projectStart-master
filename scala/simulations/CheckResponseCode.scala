package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import baseConfig.BaseSimulation


class CheckResponseCode extends BaseSimulation{

  val scn = scenario(scenarioName = "Video Game DB")

    .exec(http(requestName = "Get All Video Games - 1st call")
      .get("videogames")
      .check(status is (expected = 200)))

    .exec(http(requestName = "Get Specific Game")
      .get("videogames/1")
      .check(status in(expected = 200 to 210)))

    .exec(http(requestName = "Get All Video Games - 2nd call")
        .get("videogames")
        .check(status.not(expected = 404),status not(expected = 500)))

      setUp(
      scn.inject(atOnceUsers(users = 1))
      ).protocols(httpConf)


}
