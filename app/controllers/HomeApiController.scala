package controllers

import commons.RequestAttributes
import controllers.actions.TraceAction
import controllers.filters.SessionKeys
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton class HomeApiController @Inject()(val controllerComponents: ControllerComponents, traceAction: TraceAction) extends BaseController {

  def index: Action[AnyContent] = traceAction { request =>
    val traceId = request.session.get(SessionKeys.TRACE_ID).getOrElse("!!creating trace-id failed!!")

    Ok(s"This is an example page. (trace_id = $traceId)")
  }

}
