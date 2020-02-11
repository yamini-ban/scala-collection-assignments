package list.demo

case class Student(id: Long, name: String)

case class Marks(subjectId: Int, studentId: Long, marksObtained: Double)



class QueryStudentsAndMarks {
  def query1(param1: Int, param2: Int, param3: String,f: (Int, Int, String) => Int): Int = {
    f(param1, param2, param3)
  }

  def query2(subjectId: Int, count: Int, criteria: String): List[(String, Int)] = {
    QueryStudentsAndMarks.marks.
  }

}

object QueryStudentsAndMarks {
  val students: List[Student] = CreateList.createListOfStudents(10)
  val marks: List[Marks] = CreateList.createListOfMarks(5, 10)

  val studentCountOnStatusOfSubject: (Int, Int, String) => Int = (subjectId: Int, percentage: Int, status: String) => {
    if (status.equalsIgnoreCase("fail")) marks.filter(_.subjectId == subjectId).count(_.marksObtained < percentage)
    else marks.count(x => (x.subjectId == subjectId) && (x.marksObtained >= percentage))
  }

}
