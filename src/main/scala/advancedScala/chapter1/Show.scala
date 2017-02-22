package advancedScala.chapter1

// pull in the typeclass
import cats.Show

// pull in the implicits for the Int type
import cats.instances.int._
import cats.instances.string._

// pull in
import cats.syntax.show._

object ShowMain {
  def main(args: Array[String]): Unit = {
    // if you go looking for the companion object in the Cats source,
    // you won't find it. The boilerplate is being generated at compile
    // time by the https://github.com/mpilquist/simulacrum library.
    val showInt = Show.apply[Int]
    // syntactic sugar for calling the apply method.
    val alsoShowInt = Show[Int]

    val showString = Show[String]

    println("With extension methods...")
    println(showInt.show(123))
    println(alsoShowInt.show(123))
    println(Show[Int].show(123))
    println(showString.show("abc"))

    println("With extension methods...")
    println(123.show)
    println("abc".show)
  }
}
