package commons

import play.api.libs.typedmap.TypedKey

object RequestAttributes {
  val TraceId: TypedKey[String] = TypedKey.apply[String]("TraceId")
}
