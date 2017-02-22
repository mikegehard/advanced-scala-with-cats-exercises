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
}

object PrintSyntax {
  def format[A](value: A)(implicit printable: Printable[A]) = printable.format(value)
  def print[A](value: A)(implicit printable: Printable[A]) = println(format(value))
}
