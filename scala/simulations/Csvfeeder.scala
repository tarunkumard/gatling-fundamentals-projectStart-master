package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Csvfeeder extends BaseSimulation{

  val csvfeeder = csv(fileName = "gameCsvFile.csv").circular

}
