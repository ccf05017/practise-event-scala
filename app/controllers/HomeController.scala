package controllers

import controllers.actions.TraceAction
import controllers.filters.SessionKeys
import play.api.mvc._

import javax.inject._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, traceAction: TraceAction) extends BaseController {

  def index(): Action[AnyContent] = traceAction { implicit request: Request[AnyContent] =>
    val traceId = request.session.get(SessionKeys.TRACE_ID).getOrElse("!!creating trace-id failed!!")

    Ok(views.html.index(traceId))
  }

}
