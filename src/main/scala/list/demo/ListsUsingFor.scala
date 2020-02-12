package list.demo

class CustomException(message: String) extends Exception(message)

class ListsUsingFor {
  /**
   * Find the last element of list with its index value
   * @param list of type Int whose last element is to be found
   * @return last element of the list
   */
  def lastElementWithIndex(list: List[Int]): (Int, Int) = {
    if(list.nonEmpty)
      list.foldLeft((-1,0))((result,elem) => (result._1+1, elem))
    else
      throw new CustomException("List is Empty")
  }

  /**
   * aggregate the contents of two lists of same size into a single list
   * List(1,2) and List("a", "b") results List(List(1, "a"), List(2, "b"))
   * @param list1 of int type elements
   * @param list2 of String type elements
   * @return aggregated list
   */
  def aggregateList(list1: List[Int], list2: List[String]): List[(Int, String)] = {
    @scala.annotation.tailrec
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

  /**
   * Gives list of table of elements of the given list
   * @param list of elements
   * @return list of table of each element
   */
  def tableOfListElements(list: List[Int]): List[Int] = {
    if(list.nonEmpty) {
      for (elem <- list; x <- 1 to 10 ) yield(elem * x)
    }
    else List.empty
  }

  /**
   * Calculates sum and multiplication of the elements of given list
   * @param list input list of elements
   * @return tuple of sum and product
   */
  def sumAndMultiplication(list: List[Int]): (Int, Int) = {
    if(list.nonEmpty) {
      list.foldLeft((0,1))((result,element) => ((result._1 + element), (result._2 * element)))
    }
    else {
      (0, 0)
    }
  }
}
