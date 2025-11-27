import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import sun.jvm.hotspot.interpreter.Bytecodes.name


class ExposedStudentsDao : StudentsDao {
    override fun insertStudent(student: Student) {
        transaction {
            Students.insert {
                it[name] = student.name
                it[course] = student.course
                it[mark] = student.mark
            }
        }
    }

    override fun findStudentById(id: Int): Student? {
        var student: Student? = null
        transaction {
            var resultRow = Students.select(Students.name, Students.mark, Students.course).where { Students.id eq id }.singleOrNull()
            resultRow?.let {
                student = Student(
                    id,
                    it[Students.name],
                    it[Students.course],
                    it[Students.mark]
                )
            }
        }


        return student

    }

    override fun findStudentsByCourse(course: String): List<Student> {
        var studentlist = listOf<Student>()
        transaction {
            var results = Students.selectAll().where { Students.course eq course }
            studentlist = results.map { Student(
            it[Students.id],
            it[Students.name],
            it[Students.course],
            it[Students.mark],
            )}
        }
        return studentlist
    }


}