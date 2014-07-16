import scala.collection.immutable.Queue
import scala.collection.mutable

/**
 * Created by Aviva_Herman on 7/15/14.
 */
1 + 1

"abc" + "def"
def hello( name: String ) =
  s"hello $name"
    hello( "world" )

def fib (n: Int): Int =
  if (n == 1)
    0
  else if (n == 2)
    1
  else
    fib(n - 1) + fib(n - 2)


var fib1 = fib(1)
var fib2 = fib(2)
var fib3 = fib(3)
var fib4 = fib(4)
var fib5 = fib(5)
var fib6 = fib(6)
var fib7 = fib(7)

case class Person(
  firstName: String,
  lastName: String,
  age: Int)

def getAdults(people: List[Person]) = {
  people.filter(person => (person.age >= 18 && person.age < 65)).foreach(person => println(person.lastName + ", " + person.firstName))
  1
}


val people = List(
  Person( "Niklaus", "Wirth",     80 ),
  Person( "Anders",  "Hejlsberg", 53 ),
  Person( "Martin",  "Odersky",   55 ),
  Person( "Kenneth", "Thompson",  71 ) )


getAdults(people)
case class BinaryTreeNode(value: Int, left: Option[BinaryTreeNode], right: Option[BinaryTreeNode])
def BFS(root: BinaryTreeNode): Unit = {

  val q = new mutable.Queue[BinaryTreeNode]()

  q.enqueue(root)

  while (q.nonEmpty) {
    val node = q.dequeue()

    print(s"${node.value} ")

    node.left.foreach(l => q.enqueue(l))
    node.right.foreach(r => q.enqueue(r))
  }
}

var t8 = BinaryTreeNode(8,None,None)
var t4 = BinaryTreeNode(4,Some(t8),None)
var t5 = BinaryTreeNode(5,None,None)
var t6 = BinaryTreeNode(6,None,None)
var t7 = BinaryTreeNode(7,None,None)
var t2 = BinaryTreeNode(2,Some(t4),Some(t5))
var t3 = BinaryTreeNode(3,Some(t6),Some(t7))
var t1 = BinaryTreeNode(1,Some(t2),Some(t3))
BFS(t1)

def DFS(root: BinaryTreeNode): Unit = {

  print(s"${root.value} ")

  root.left.foreach { l => DFS(l) }

  root.right.foreach { r => DFS(r) }

}


DFS(t1)

Option(null)