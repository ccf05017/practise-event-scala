package controllers.actions

import commons.RequestAttributes

import javax.inject._
import play.api.mvc._

import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}

class TraceAction @Inject()(parser: BodyParsers.Default)(implicit ec: ExecutionContext) extends ActionBuilderImpl(parser) {

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]): Future[Result] = {
    val traceId = UUID.randomUUID().toString
    val traceRequest = request.addAttr(RequestAttributes.TraceId, traceId)
    block(traceRequest).map { result =>
      result.withHeaders("Trace-ID" -> traceId)
    }
  }

}
