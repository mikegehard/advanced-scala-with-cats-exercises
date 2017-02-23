package advancedScala.chapter1

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val printableInt = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }

  implicit val printableString = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val printableCat = new Printable[Cat] {
    override def format(value: Cat): String =
      s"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat."
  }
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)

  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(format(value))
}

object PrintSyntax {

  implicit class PrintOps[A](value: A) {
    def format(implicit p: Printable[A]): String = p.format(value)

    def print(implicit p: Printable[A]): Unit = println(value.format)
  }

}

object PrintableMain {
  def main(args: Array[String]): Unit = {
    // Need this to get the type class instances.
    import PrintableInstances._
    // Need this to get the extension methods.
    import PrintSyntax._
    Printable.print(Cat("Fluffy", 2, "black"))
    Cat("Blinky", 10, "orange").print
  }
}
