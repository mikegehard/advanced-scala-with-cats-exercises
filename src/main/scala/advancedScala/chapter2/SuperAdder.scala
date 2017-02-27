package advancedScala.chapter2

import cats.kernel.Monoid


object SuperAdder {
  def add[A : Monoid](items: List[A]): A = items.foldLeft(Monoid[A].empty)(Monoid[A].combine)
}
