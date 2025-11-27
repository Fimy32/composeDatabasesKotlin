interface StudentsDao {
    fun insertStudent(student: Student)
    fun findStudentById(id: Int): Student?
}