package advancedScala.chapter1

// pull in the typeclass
import cats.Show

// pull in the implicits for the Int type
import cats.instances.int._
import cats.instances.string._

// pull in
import cats.syntax.show._

object ShowableInstances {
  implicit val catShow: Show[Cat] = {
    //    Show.show(cat => s"${cat.name.show} is a ${cat.age.show} year-old ${cat.color.show} cat.")
    //    val stringShow = Show[String]
    //    val intShow = Show[Int]
    //    Show.show(cat => s"${stringShow.show(cat.name)} is a ${intShow.show(cat.age)} year-old ${stringShow.show(cat.color)} cat.")
    Show.show(cat => s"${Show[String].show(cat.name)} is a ${Show[Int].show(cat.age)} year-old ${Show[String].show(cat.color)} cat.")
  }

}

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

    import ShowableInstances._
    val cat = Cat("Betty", 6, "grey")
    println(Show[Cat].show(cat))
  }
}
