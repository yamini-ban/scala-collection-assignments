package list.demo

object AppDriver extends App{

  val queryStudentsAndMarks = new QueryStudentsAndMarks

  val listsUsingFor = new ListsUsingFor

  val count = queryStudentsAndMarks.query1And2(3, 95, "fail",QueryStudentsAndMarks.studentCountOnStatusOfSubject)

  val count2 = queryStudentsAndMarks.query1And2(3, 95, "pass",QueryStudentsAndMarks.studentCountOnStatusOfSubject)

  println("Fail Count: " + count)

  println("Pass Count: " + count2)

  val list1 = List(2,1,4,3,6,5)

  val list2 = List("a", "b", "c", "d", "e", "f")

  println("Last element of the list with index is: " + listsUsingFor.lastElementWithIndex(list1))

  println("Aggregate list of two lists is: " + listsUsingFor.aggregateList(list1, list2))

  println("Table of list elements is: " + listsUsingFor.tableOfListElements(list1))

  println("Sum and Multiplication of the list elements is: " + listsUsingFor.sumAndMultiplication(list1))
}
