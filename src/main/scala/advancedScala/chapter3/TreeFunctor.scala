package advancedScala.chapter3

import cats.Functor

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {
  implicit val functor = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: (A) => B): Tree[B] = fa match {
      case Branch(left: Tree[A], right: Tree[A]) =>
        Branch(map(left)(f), map(right)(f))
      case Leaf(value) =>
        Leaf(f(value))
    }
  }
}
