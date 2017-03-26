package advancedScala.chapter4

trait Monad[F[_]] {
  def pure[A](a: A): F[A]

  def flatMap[A, B](value: F[A])(f: A => F[B]): F[B]

  def map[A, B](value: F[A])(f: A => B): F[B] =
    flatMap(value)(a => pure(f(a)))
}

object MonadMapMain {
  def main(args: Array[String]): Unit = {


  }
}
