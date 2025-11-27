import kotlinx.coroutines.runInterruptible
import org.jetbrains.exposed.v1.core.Table

object Students : Table("Students") {
    val id = integer("id").autoIncrement()
    val name = text("name")
    val course = text("course")
    val mark = integer("mark")

    override val primaryKey = PrimaryKey(id)
}