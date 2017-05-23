package advancedScala.chapter7

object Foldable {
  def show[A](l: List[A]): String = l.foldLeft("nil")((acc, item) => s"$item then $acc")
  def show2[A](l: List[A]): String = l.foldRight("nil")((item, acc) => s"$item then $acc")

  def main(args: Array[String]): Unit = {
    println(Foldable.show(Nil))
    println(Foldable.show(List(1, 2, 3)))

    println(Foldable.show2(Nil))
    println(Foldable.show2(List(1, 2, 3)))
  }
}
