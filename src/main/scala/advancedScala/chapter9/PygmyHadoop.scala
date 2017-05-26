package advancedScala.chapter9

import cats.Monoid
import cats.syntax.semigroup._
import cats.instances.int._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object PygmyHadoop {
  def foldMap[A, B: Monoid](items: Vector[A])(f: A => B): B =
    items.map(f).foldLeft(Monoid[B].empty)(_ |+| _)

  def parallelFoldMap[A, B: Monoid](items: Vector[A])(f: A => B): Future[B] = {
    val numberOfCores: Int = Runtime.getRuntime.availableProcessors
    val batchSize = (1.0 * items.size / numberOfCores).ceil.toInt

    val batches: Iterator[Vector[A]] = items.grouped(batchSize)

    val futures: Iterator[Future[B]] = batches.map(b => Future(foldMap(b)(f)))

    Future.sequence(futures).map(items => items.foldLeft(Monoid[B].empty)(_ |+| _))
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }


  def main(args: Array[String]) = {
    val serialResult: Int = time {
      foldMap((1 to 1000000).toVector)(identity)
    }

    println(serialResult)

    val parallelResult = time {
      Await.result(parallelFoldMap((1 to 1000000).toVector)(identity), 1.second)
    }

    println(parallelResult)
  }
}
