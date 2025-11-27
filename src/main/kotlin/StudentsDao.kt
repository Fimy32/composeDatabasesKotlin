interface StudentsDao {
    fun insertStudent(student: Student)
    fun findStudentById(id: Int): Student?
    fun findStudentsByCourse(course: String): List<Student>
}