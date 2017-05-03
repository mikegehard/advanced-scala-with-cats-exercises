
import cats.data.Writer

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import cats.syntax.writer._
import cats.syntax.applicative._
import cats.instances.vector._

object WriterFactorial {
  type Logged[A] = Writer[Vector[String], A]

  def factorial(n: Int): Logged[Int] = {
    for {
      ans <- if (n == 0)
        1.pure[Logged]
      else
        factorial(n - 1).map(_ * n)
      _ <- Vector(s"fact $n $ans").tell
    } yield ans
  }

  def main(args: Array[String]) = {
    val result: Seq[(Vector[String], Int)] = Await.result(Future.sequence(Vector(
      Future(factorial(13).run),
      Future(factorial(3).run)
    )), 5.seconds)

    val foo: ((Vector[String], Int)) => Unit = (x) => {
      println(x._1)
      println(x._2)
    }

    result.foreach(foo)
  }
}
