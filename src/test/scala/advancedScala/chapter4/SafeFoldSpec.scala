package advancedScala.chapter4

import org.scalatest.FunSuite

class SafeFoldSpec extends FunSuite {

  test("Does not blow the stack") {
    val items = List.fill(30000)(1)
    try {
      SafeFold.foldRight[Int, Int](items, 0)(_ + _)
    } catch {
      case _: java.lang.StackOverflowError => fail("Should not throw exception!!!")
    }
  }
}
