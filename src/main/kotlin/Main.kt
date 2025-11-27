import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    Database.connect(url = "jdbc:sqlite:students:db", driver = "org.sqlite.JDBC")

    val DatabaseHandler = ExposedStudentsDao()

    var studentID = 0
    transaction {

        SchemaUtils.create(Students)

        for (i in 1..10) {
            studentID = Students.insert {
                it[name] = "Student${i}"
                it[course] = "Course${i}"
                it[mark] = 100
            }[Students.id]
        }
//
//        val results = Students.selectAll()
//        results.forEach {
//            println("Title: ${it[Students.name]}, Artist: ${it[Students.course]}")
//        }


    }

    print(DatabaseHandler.findStudentById(5))

}
