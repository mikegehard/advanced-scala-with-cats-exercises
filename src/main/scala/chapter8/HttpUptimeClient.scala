package advancedScala.chapter8

import scala.concurrent.Future

// An example of what a concrete implementation might look like
class HttpUptimeClient extends UptimeClient[Future] {
  override def getUptime(hostname: String): Future[Int] = Future.successful(100)
}
