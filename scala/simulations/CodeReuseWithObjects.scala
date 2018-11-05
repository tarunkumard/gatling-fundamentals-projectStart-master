package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class CodeReuseWithObjects extends BaseSimulation{


  def getAllvideoGames() :ChainBuilder = {
    exec(http( requestName = "Get All Video Games")
    .get("videogames")
    .check(status is (expected = 200)))
  }



  def getSpecificVideoGames():ChainBuilder = {
    exec(http( requestName = "Get Specific Game")
      .get("videogames/1")
      .check(status in(expected = 200 to 210)))

  }

  val scn = scenario( scenarioName = "Video Game DB")
    .exec(getAllvideoGames())
      .pause(duration = 5)
    .exec(getSpecificVideoGames())
      .pause(duration = 5)
    .exec(getAllvideoGames())

  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpConf)
}
