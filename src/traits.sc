trait Iterator[T] {
  def next: Option[T]
}


trait Iterable[T] {
  def iterator: Iterator[T]

  def headOption: Option[T] = iterator.next

  def contains(value: T): Boolean = {
    val i = iterator

    var found = false

    while (!found) {
      val curr = i.next.getOrElse(null)

      if (curr == null)
        return false
      else if (curr == value)
        found = true
    }

    found
  }

  def size: Int = {
    var count = 0

    val i = iterator

    while (i.next.nonEmpty) {
      count = count + 1
    }

    count
  }
}

case class Node[T](value: T, next: Option[Node[T]]) {}

case class myList[T](head: Node[T]) extends Iterable[T] {

  case class listIterator() extends Iterator[T] {
    var node = head

    def next: Option[T] = {
      val curr = node

      if (node != null) {
        node = node.next.orNull
        Some(curr.value)
      } else {
        None
      }
    }
  }

  def iterator = listIterator()
}

case class myArray[T](arr: Array[T]) extends Iterable[T] {

  case class arrayIterator() extends Iterator[T] {
    var idx = 0

    def next: Option[T] = {

      if (idx < arr.length) {
        idx = idx + 1
        Some(arr(idx - 1))
      } else {
        None
      }
    }
  }

  def iterator: Iterator[T] = arrayIterator()
}