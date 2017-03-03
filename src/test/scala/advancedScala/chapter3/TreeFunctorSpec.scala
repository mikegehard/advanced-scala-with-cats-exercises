package advancedScala.chapter3

import cats.Functor
import org.scalatest.PropSpec
import org.scalatest.prop.PropertyChecks
import cats.syntax.functor._

class TreeFunctorSpec extends PropSpec with PropertyChecks {

  property("mapping over a tree") {
    import advancedScala.chapter3.Tree.functor

    val cases = Table(
      (
        "inputTree",
        "function",
        "expectedTree"
      ),
      (
        Branch(Leaf(2), Leaf(5)),
        (x: Int) => x + 6,
        Branch(Leaf(8), Leaf(11))
      ),
      (
        Branch(Leaf(2), Leaf(5)),
        (x: Int) => x * 3,
        Branch(Leaf(6), Leaf(15))
      )
    )

    forAll(cases) { (input: Tree[Int], op: Int => Int, output: Tree[Int]) =>
      assert(Functor[Tree].map(input)(op) == output)
    }

    forAll(cases) { (input: Tree[Int], op: Int => Int, output: Tree[Int]) =>
      assert(input.map(op) == output)
    }
  }

}
