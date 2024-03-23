package controllers.filters

import javax.inject.Inject
import play.api.http.HttpFilters
import play.api.mvc.EssentialFilter

class Filters @Inject()(traceFilter: TraceFilter) extends HttpFilters{
  def filters: Seq[EssentialFilter] = Seq(traceFilter)
}
