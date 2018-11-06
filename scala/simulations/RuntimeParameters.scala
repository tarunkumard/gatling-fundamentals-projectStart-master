package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class RuntimeParameters extends BaseSimulation{

  def getAllvideoGames() :ChainBuilder = {
    exec(
      http(requestName = "Get All Video Games")
        .get("videogames")
        .check(status.is(expected = 200))    )
  }

  val scn = scenario(scenarioName = "Video Game DB")
      .forever(){
        exec(getAllvideoGames())
              }
setUp(
  scn.inject(
    nothingFor(5 seconds),
    rampUsers(users =1) over(1 second))
  )
    .protocols(httpConf).maxDuration(duration = 20 seconds)



}
