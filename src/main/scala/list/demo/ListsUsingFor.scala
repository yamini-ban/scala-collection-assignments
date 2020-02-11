package list.demo

class CustomException(message: String) extends Exception(message)

class ListsUsingFor {
  /**
   * Find the last element of list with its index value(dont use inbuilt methods to extract last element directly)
   * @param list whose last element is to be found
   * @return last element of the list
   */
  def lastElementWithIndex(list: List[Int]): (Int, Int) = {
    if(!list.isEmpty)
      list.foldLeft((-1,0))((result,elem) => (result._1+1, elem))
    else
      throw new CustomException("List is Empty")
  }

  /**
   * aggregate the contents of two lists of same size into a single list
   * List(1,2) and List("a", "b") results List(List(1, "a"), List(2, "b"))
   * @param list1
   * @param list2
   * @return aggregated list
   */
  def aggregateList(list1: List[Int], list2: List[String]): List[(Int, String)] = {
    def innerAggregateList(list1: List[Int], list2: List[String], result: List[(Int, String)]): List[(Int, String)] = {
      (list1, list2) match {
        case (Nil, Nil) =>result.reverse
        case (_, Nil) => result.reverse
        case (Nil , _) => result.reverse
        case (first1 :: rest1, first2 :: rest2) => {
          innerAggregateList(rest1, rest2, (first1, first2) :: result)
        }
      }
    }
    innerAggregateList(list1, list2, List.empty[(Int, String)])
  }

  def tableOfListElements(list: List[Int]): List[Int] = {
    if(list.nonEmpty) {
      for (elem <- list; x <- 1 to 10 ) yield(elem * x)
    }
    else List.empty
  }

  def sumAndMultiplication(list: List[Int]): (Int, Int) = {
    if(list.nonEmpty) {
      list.foldLeft((0,1))((result,element) => ((result._1 + element), (result._2 * element)))
    }
    else {
      (0, 0)
    }
  }

  def higherPercentage(cutOff: Double): List[Student] = {
    val students = QueryStudentsAndMarks.percentageOfStudents.iterator.map(
      elem => QueryStudentsAndMarks.students.filter(_.id == elem._1)
    )
    students.flatten.toList
  }
}
