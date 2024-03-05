import kotlinx.datetime.*
import java.time.Year

fun isLeapYear(year: String): Boolean {
    return Year.of(year.toInt()).isLeap
}

fun main() {
    val year = readln()
    println(isLeapYear(year))
}