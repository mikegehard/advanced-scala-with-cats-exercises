package advancedScala.chapter2

import org.scalatest.PropSpec
import org.scalatest.prop.PropertyChecks


class BooleanAndMonoid extends PropSpec with PropertyChecks {

  import MyBooleanInstances.andMonoid

  val m: MyMonoid[Boolean] = MyMonoid[Boolean]
  property("associative law holds") {
    forAll { (a: Boolean, b: Boolean, c: Boolean) =>
      assert(m.combine(a, m.combine(b, c)) == m.combine(m.combine(a, b), c))
    }
  }

  property("identity law holds") {
    forAll { (a: Boolean) =>
      assert(m.combine(a, m.empty) == m.combine(m.empty, a))
    }
  }
}

class BooleanOrMonoid extends PropSpec with PropertyChecks {

  import MyBooleanInstances.orMonoid

  val m: MyMonoid[Boolean] = MyMonoid[Boolean]
  property("associative law holds") {
    forAll { (a: Boolean, b: Boolean, c: Boolean) =>
      assert(m.combine(a, m.combine(b, c)) == m.combine(m.combine(a, b), c))
    }
  }

  property("identity law holds") {
    forAll { (a: Boolean) =>
      assert(m.combine(a, m.empty) == m.combine(m.empty, a))
    }
  }
}
