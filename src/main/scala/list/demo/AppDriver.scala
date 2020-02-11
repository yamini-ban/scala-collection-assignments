package list.demo

object AppDriver extends App{



  val queryStudentsAndMarks = new QueryStudentsAndMarks

  val count = queryStudentsAndMarks.query1(3, 95, "fail",QueryStudentsAndMarks.studentCountOnStatusOfSubject)

  val count2 = queryStudentsAndMarks.query1(3, 95, "pass",QueryStudentsAndMarks.studentCountOnStatusOfSubject)

  println(count)

  println(count2)


}
