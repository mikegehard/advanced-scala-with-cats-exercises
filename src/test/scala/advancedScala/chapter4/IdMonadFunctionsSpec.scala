package advancedScala.chapter4

import org.scalatest.FunSuite

class IdMonadFunctionsSpec  extends FunSuite {

  test("pure returns the same value") {
    assert(IdMonadFunctions.pure(123) == 123)
  }
}
