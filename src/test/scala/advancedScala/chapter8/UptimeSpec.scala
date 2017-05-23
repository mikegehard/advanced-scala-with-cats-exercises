package advancedScala.chapter8

import org.scalatest.FunSuite

class UptimeSpec extends FunSuite {
  test("it works") {
    val hosts    = Map("host1" -> 10, "host2" -> 6)
    val client   = new TestUptimeClient(hosts)
    val service  = new UptimeService(client)
    val actual   = service.getTotalUptime(hosts.keys.toList)
    val expected = hosts.values.sum
    assert(actual == expected)
  }
}
