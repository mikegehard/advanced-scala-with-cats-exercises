package advancedScala.chapter2

trait MySemigroup[A] {
  def combine(x: A, y: A): A
}

trait MyMonoid[A] extends MySemigroup[A] {
  def empty: A
}

object MySemigroup {
  def apply[A](implicit semigroup: MySemigroup[A]) = semigroup
}

object MyMonoid {
  def apply[A](implicit monoid: MyMonoid[A]) = monoid
}


