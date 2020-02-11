package list.demo

object CreateList {

  def createListOfStudents(size: Int): List[Student] = {
    innerCreateListOfStudents(List.empty[Student], size)
  }

  @scala.annotation.tailrec
  private def innerCreateListOfStudents(list: List[Student], size: Int): List[Student] = {
    if(size >0)
      innerCreateListOfStudents(Student(size.toLong, "yamini"+size) :: list, size - 1)
    else
      list
  }

  def createListOfMarks(numberOfSubjects: Int, numberOfStudents: Int): List[Marks] = {
    innerCreateListOfMarks(numberOfSubjects, numberOfStudents, List.empty[Marks], numberOfSubjects, numberOfStudents)
  }

  @scala.annotation.tailrec
  def innerCreateListOfMarks(numberOfSubjects: Int, numberOfStudents: Int, list: List[Marks], subjectsLeft: Int, studentsLeft: Int): List[Marks] = {
    if(studentsLeft == 0) {
      if(subjectsLeft == 0){
        list
      }
      else {
        innerCreateListOfMarks(numberOfSubjects, numberOfStudents, list, subjectsLeft - 1, numberOfStudents)
      }
    }
    else {
      if(studentsLeft % 2 == 0) {
        val newList = Marks(subjectsLeft, studentsLeft, 90 - subjectsLeft*studentsLeft - subjectsLeft) :: list
        innerCreateListOfMarks(numberOfSubjects, numberOfStudents, newList, subjectsLeft, studentsLeft - 1)
      }
      else {
        val newList = Marks(subjectsLeft, studentsLeft, 90 + studentsLeft - subjectsLeft) :: list
        innerCreateListOfMarks(numberOfSubjects, numberOfStudents, newList, subjectsLeft, studentsLeft - 1)
      }
    }
  }

}
