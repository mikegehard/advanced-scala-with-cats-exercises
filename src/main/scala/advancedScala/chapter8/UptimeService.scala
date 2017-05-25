package advancedScala.chapter8

import cats.{Applicative, Traverse}
import cats.implicits._

import scala.language.higherKinds

class UptimeService[F[_] : Applicative](client: UptimeClient[F]) {
  def getTotalUptime(hostnames: List[String]): F[Int] =
    Traverse[List].traverse(hostnames)(client.getUptime).map(_.sum)
}
