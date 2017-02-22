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
      s"${PrintSyntax.format(value.name)} is a ${PrintSyntax.format(value.age)} year-old ${PrintSyntax.format(value.color)} cat."
  }
}

object PrintSyntax {
  def format[A](value: A)(implicit printable: Printable[A]) = printable.format(value)
  def print[A](value: A)(implicit printable: Printable[A]) = println(format(value))
}

case class Cat(name: String, age: Int, color: String)

object Main {
  def main(args: Array[String]): Unit = {
    // Need this to get the type class instances.
    import PrintableInstances._
    val cat = Cat("Fluffy", 2, "black")
    PrintSyntax.print(cat)
  }
}
