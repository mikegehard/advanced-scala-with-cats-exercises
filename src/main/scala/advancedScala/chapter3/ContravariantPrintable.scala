package advancedScala.chapter3

final case class Box[A](value: A)

trait Printable[A] {
  def format(value: A): String

  def contramap[B](func: B => A): Printable[B] = {
    val original = this
    new Printable[B] {
      override def format(value: B) = original.format(func(value))
    }
  }
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)
}

object PrintableInstances {
  implicit val stringPrintable =
    new Printable[String] {
      def format(value: String): String =
        "\"" + value + "\""
    }
  implicit val booleanPrintable =
    new Printable[Boolean] {
      def format(value: Boolean): String =
        if (value) "yes" else "no"
    }

  // make sure you keep it generic in A so use the Printable for that A
  implicit def boxPrintable[A](implicit p: Printable[A]) = p.contramap[Box[A]](_.value)
}

object ContramapMain {
  def main(args: Array[String]): Unit = {
    import PrintableInstances._
    println(Printable.format("hello"))
    println(Printable.format(true))
    println(Printable.format(Box("hello world")))
  }
}

