package controllers

import commons.RequestAttributes
import controllers.actions.TraceAction
import controllers.filters.SessionKeys
import play.api.mvc._

import javax.inject._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, traceAction: TraceAction) extends BaseController {

  def index(): Action[AnyContent] = traceAction { implicit request: Request[AnyContent] =>
    val traceId = request.attrs(RequestAttributes.TraceId)

    Ok(views.html.index(traceId))
  }

}
