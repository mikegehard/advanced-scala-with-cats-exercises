package advancedScala.chapter1

import java.util.Date

import cats.Eq
import cats.syntax.eq._
import cats.instances.int._
import cats.instances.option._
import cats.syntax.option._
// so you can compare result of getTime
import cats.instances.long._
import cats.instances.string._


object EqInstances {
  implicit val dateEqual = Eq.instance[Date] { (d1, d2) =>
    d1.getTime === d2.getTime
  }

  implicit val catEqual = Eq.instance[Cat] { (c1, c2) =>
    c1.name === c2.name &&
    c1.age === c2.age &&
    c1.color === c2.color
  }
}

object EqMain {
  def main(args: Array[String]): Unit = {
    val intEq = Eq[Int]

    println("Int eq...")
    println(intEq.eqv(1, 2))
    println(intEq.eqv(1, 1))
    // won't compile
    //    println(intEq.eqv(1, "1"))

    println(1 === 2)
    println(1 === 1)
    // won't compile
    //    println(1 === "1")


    println("Option eq...")
    // wont' compile
    //    Some(1) === None
    println((Some(1): Option[Int]) === (None: Option[Int]))
    println(Option(1) === Option.empty[Int])
    println(1.some === None)

    println("Date eq...")
    val x = new Date()
    Thread.sleep(1000)
    val y = new Date()

    import EqInstances._
    println(x === y)


    println("Cat eq...")
    val fluffy = Cat("Fluffy", 10, "orange")
    val puffy = Cat("Puffy", 10, "orange")

    println(fluffy === puffy)
    println(fluffy === fluffy)

    println("Cat option eq...")

    println(Option(fluffy) === None)
    println(Option(fluffy) === Option(puffy))
    println(Option(fluffy) === Option(fluffy))
  }
}
