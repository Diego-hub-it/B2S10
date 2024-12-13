import rx._

object Pregunta01 extends App{
  implicit val ctx: Ctx.Owner = Ctx.Owner.safe()
  // Define un Var reactivo para las calificaciones
  val calificaciones: Var[Seq[Int]] = Var(Seq.empty[Int])

  // Define un Rx derivado que calcula la suma automáticamente
  val suma: Rx[Int] = Rx {
    calificaciones().sum
  }

  // Observador para imprimir la suma cada vez que cambie
  suma.trigger {
    println("Suma actual = " + suma())
  }

  // Actualiza las calificaciones y observa el comportamiento
  println("Agregando calificaciones...")
  calificaciones() = calificaciones.now :+ 10 // Agrega una calificación
  calificaciones() = calificaciones.now :+ 20 // Agrega otra calificación
}
