package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import baseConfig.BaseSimulation

class CheckResponseBodyAndExtract extends BaseSimulation{

  val scn = scenario(scenarioName = "Video Game DB")
    .exec(http(requestName = "Get Specific Game")
      .get("videogames/1")
      .check(jsonPath(path = "$.name").is(expected = "Resident Evil 4")))

    .exec(http(requestName = "Get All Video games - 2nd Call")
      .get("videogames")
      .check(jsonPath(path = "$[1].id").saveAs(key ="gameId")))
      .exec{session => println(session);session}


    .exec(http(requestName = "Get All Video games - 2nd Call with parameter")
      .get("videogames/${gameId}")
      .check(jsonPath(path = "$.name").is(expected ="Gran Turismo 3"))
      .check(bodyString.saveAs(key = "responseBody"))    )
    .exec { session => println(session("responseBody").as[String]);session}




  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpConf)

}
