package advancedScala.chapter2

object MySetInstances {
  // Need to make this a method so we can pass along the A type
  implicit def union[A] = new MyMonoid[Set[A]] {
    override def empty: Set[A] = Set.empty[A]

    override def combine(x: Set[A], y: Set[A]): Set[A] = x.union(y)
  }

  implicit def intersection[A] = new MySemigroup[Set[A]] {
    def combine(x: Set[A], y: Set[A]): Set[A] = x.intersect(y)
  }
}
