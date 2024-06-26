package controllers.filters

import commons.RequestAttributes
import org.apache.pekko.stream.Materializer

import javax.inject.Inject
import play.api.mvc._

import java.util.UUID
import scala.concurrent.ExecutionContext

class TraceFilter @Inject()(implicit val ec: ExecutionContext) extends EssentialFilter {
  def apply(nextFilter: EssentialAction) = EssentialAction { requestHeader =>
    val traceId = UUID.randomUUID().toString

    nextFilter(requestHeader.addAttr(RequestAttributes.TraceId, traceId))
  }
}
