import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulations.{CodeReuseWithObjects, Csvfeeder}

object MyGatlingRunner {

  def main(args: Array[String]): Unit = {

    val simClass = classOf[Csvfeeder].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
