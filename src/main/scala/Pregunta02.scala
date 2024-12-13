import rx._

object Pregunta02 extends App{
  implicit val ctx: Ctx.Owner = Ctx.Owner.safe()

  // Define variables reactivas para masa y velocidad
  val masa: Var[Double] = Var(1000.0) // Masa inicial en kilogramos
  val velocidad: Var[Double] = Var(0.0) // Velocidad inicial en metros por segundo

  // Define un Rx para calcular la energía cinética
  val energiaCinetica: Rx[Double] = Rx {
    0.5 * masa() * Math.pow(velocidad(), 2) // Fórmula de energía cinética
  }

  // Define un umbral para la alerta
  val umbral: Double = 1_000_000.0

  // Observador para la energía cinética
  energiaCinetica.trigger {
    println(f"Energía cinética actual: ${energiaCinetica()}%.2f J")
    if (energiaCinetica() > umbral) {
      println("Alerta: Energía cinética muy alta, reduzca la velocidad.")
    }
  }

  // Simula cambios en la masa y velocidad
  println("Actualizando parámetros...")
  velocidad() = 20.0 // Cambia la velocidad a 20 m/s
  velocidad() = 40.0 // Cambia la velocidad a 40 m/s
  masa() = 2000.0    // Cambia la masa a 2000 kg
  velocidad() = 50.0 // Cambia la velocidad a 50 m/s
}
