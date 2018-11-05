package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class RuntimeParameters extends BaseSimulation{

  def getAllvideoGames() :ChainBuilder = {
    exec(
      http(requestName = "Get All Video Games")
        .get("videogames")
        .check(status.is(expected = 200))    )
  }



}
