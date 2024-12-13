import rx._

object Pregunta02 extends App{

  val masa: Var[Double] = Var(1000.0)
  val velocidad: Var[Double] = Var(0.0)

  val energiaCinetica: Rx[Double] = Rx {
    0.5 * masa() * Math.pow(velocidad(), 2)
  }

  val umbral: Double = 1000000.0

  energiaCinetica.trigger {
    val enerCin = energiaCinetica.now
    println("Energía cinética actual: "+ enerCin)
    if (enerCin > umbral) {
      println("Alerta: Energía cinética muy alta, reduzca la velocidad.")
    }
  }

  println("Actualizando parámetros...")
  velocidad() = 20.0
  velocidad() = 40.0
  masa() = 2000.0
  velocidad() = 50.0
}
