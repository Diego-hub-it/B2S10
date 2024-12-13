import rx._

object Pregunta01 extends App{
  val calificaciones: Var[Seq[Int]] = Var(Seq.empty[Int])

  val suma: Rx[Int] = Rx {
    calificaciones().sum
  }

  suma.trigger {
    println("Suma actual = " + suma)
  }

  println("Agregando calificaciones...")
  calificaciones() = calificaciones.now :+ 10
  calificaciones() = calificaciones.now :+ 20
}
