package advancedScala.chapter4

import cats.Id

object IdMonadFunctions {
  def pure[A](v: A): Id[A] = v
  def map[A, B](v: A)(f: A => B): Id[B] = f(v)
  def flatMap[A, B](v: A)(f: A => Id[B]): Id[B] = map(v)(f)
}
