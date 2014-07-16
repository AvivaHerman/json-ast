abstract class JsonValue

abstract class JsonPrimitive extends JsonValue

case object JsonNull extends JsonPrimitive

abstract class JsonNumber extends JsonPrimitive
case class JsonInt(x: Int) extends JsonNumber
case class JsonDouble(x: Double) extends JsonNumber
case class JsonBoolean(b: Boolean) extends JsonPrimitive

case class JsonField(key: String, value: JsonValue)

case class JsonObject(fields: JsonField*) extends JsonValue {
  def add(newFields: JsonField*) = {
    newFields.foreach(field => fields = field +: fields)
  }
}