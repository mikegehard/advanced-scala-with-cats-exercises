package advancedScala.chapter2

import org.scalatest.PropSpec
import org.scalatest.prop.PropertyChecks

import cats.instances.int._
import cats.instances.option._
import advancedScala.chapter2.OrderInstances._

class SuperAdderSpec extends PropSpec with PropertyChecks {

  property("adding integers works") {
    val answers =
      Table(
        ("items", "expectedSum"),
        (List(), 0),
        (List(1, 2, 3), 6)
      )
    forAll(answers) { (items: List[Int], expectedSum: Int) =>
      assert(SuperAdder.add(items) == expectedSum)
    }
  }

  property("adding options of integers works") {
    val answers =
      Table(
        ("items", "expectedSum"),
        (List(), None),
        (List(Option(1), Option(2), Option(3)), Option(6))
      )
    forAll(answers) { (items: List[Option[Int]], expectedSum: Option[Int]) =>
      assert(SuperAdder.add(items) == expectedSum)
    }
  }

  property("adding orders works") {
    val answers =
      Table(
        ("items", "expectedSum"),
        (List(), Order(0, 0)),
        (List(Order(100, 2), Order(223, 2), Order(305, 44)), Order(100 + 223 + 305, 2 + 2 + 44))
      )
    forAll(answers) { (items: List[Order], expectedSum: Order) =>
      assert(SuperAdder.add(items) == expectedSum)
    }
  }
}
