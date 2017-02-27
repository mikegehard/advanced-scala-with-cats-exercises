package advancedScala.chapter2

import org.scalatest.PropSpec
import org.scalatest.prop.PropertyChecks

class SetUnion extends PropSpec with PropertyChecks {

  import MySetInstances.union

  val m: MyMonoid[Set[Int]] = MyMonoid[Set[Int]]
  property("associative law holds") {
    forAll { (a: Set[Int], b: Set[Int], c: Set[Int]) =>
      assert(m.combine(a, m.combine(b, c)) == m.combine(m.combine(a, b), c))
    }
  }

  property("identity law holds") {
    forAll { (a: Set[Int]) =>
      assert(m.combine(a, m.empty) == m.combine(m.empty, a))
    }
  }
}

class SetIntersection extends PropSpec with PropertyChecks {

  import MySetInstances.intersection

  val s: MySemigroup[Set[Int]] = MySemigroup[Set[Int]]
  property("associative law holds") {
    forAll { (a: Set[Int], b: Set[Int], c: Set[Int]) =>
      assert(s.combine(a, s.combine(b, c)) == s.combine(s.combine(a, b), c))
    }
  }
}
