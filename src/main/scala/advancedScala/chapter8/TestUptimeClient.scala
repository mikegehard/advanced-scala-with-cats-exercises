package advancedScala.chapter8

import cats.Id

case class TestUptimeClient(hosts: Map[String, Int]) extends UptimeClient[Id] {
  override def getUptime(hostname: String): Int = hosts.getOrElse(hostname, 0)
}
