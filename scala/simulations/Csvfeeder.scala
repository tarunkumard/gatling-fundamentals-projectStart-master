package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class Csvfeeder extends BaseSimulation{

  val csvfeeder = csv(fileName = "gameCsvFile.csv").circular
 def getSpecificVideoGame() :ChainBuilder = {
   repeat( times = 10){
     feed(csvfeeder).
       exec(http(requestName = "Get Specific Video Game" )
         .get("videogames/${gameId}")
         .check(jsonPath(path="$.name").is(expected = "${gameName}"))
         .check(status.is(expected = 200)))
       .pause(duration = 1)
   }

 }
val scn = scenario(scenarioName = "Video Game DB")
    .exec(getSpecificVideoGame())

  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpConf)

}
