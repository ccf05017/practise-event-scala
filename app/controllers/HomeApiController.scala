package controllers

import commons.RequestAttributes
import controllers.actions.TraceAction
import controllers.filters.SessionKeys
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton class HomeApiController @Inject()(val controllerComponents: ControllerComponents, traceAction: TraceAction) extends BaseController {

  def index: Action[AnyContent] = traceAction { request =>
    val traceId = request.attrs(RequestAttributes.TraceId)

    Ok(s"This is an example page. (trace_id = $traceId)")
  }

}
