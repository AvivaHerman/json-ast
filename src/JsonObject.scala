/**
 * Created by Aviva_Herman on 7/16/14.
 */

abstract class JsonValue

abstract class JsonPrimitive extends JsonValue

case object JsonNull extends JsonPrimitive

abstract class JsonNumber extends JsonPrimitive
case class JsonInt(x: Int) extends JsonNumber
case class JsonDouble(x: Double) extends JsonNumber
case class JsonBoolean(b: Boolean) extends JsonPrimitive

case class JsonField(key: String, value: JsonValue)

class JsonObject(var fields: JsonField*) extends JsonValue {

  def put(newFields: JsonField*) = {
    fields = newFields ++ fields
  }
}

