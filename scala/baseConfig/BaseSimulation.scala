package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class BaseSimulation extends Simulation{
  val httpConf = http
    .baseURL(url = "http://localhost:8080/app/")
    .header(name = "Accept",value = "application/json")
.proxy(Proxy("localhost",8888).httpsPort(port=8888))
}
