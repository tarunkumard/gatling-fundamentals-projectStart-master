import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MyFirstTest extends BaseSimulation {

  // 1 Common HTTP Configuration

  // 2 Scenario Definition
  val scn = scenario(scenarioName = "My first Test")
    .exec(http(requestName = "Get All Games")
      .get("videogames"))

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users=1))
  ).protocols(httpConf)


}
