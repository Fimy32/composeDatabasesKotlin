class Student(val id: Int, var name: String, var course: String, var mark: Int) {

    override fun toString(): String {
        return "$name, ID $id, is on $course, mark is $mark which is a grade of ${getGrade()}"
    }

    fun getGrade(): String {
        return when(mark) {
            in 70..100 -> "First"
            in 60..69 -> "2/1"
            in 50..59 -> "2/2"
            in 40..49 -> "Third"
            else -> "Fail"
        }
    }
}
