import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val x = scanner.nextInt()
    var n = x - 1

    val exerciseList = mutableListOf(x)
    repeat(n) {
        exerciseList.add(n)
        n--
    }

    if (x < 1) {
        println("")
    } else {
        exerciseList.forEach { item ->
            print("$item ")
        }
    }
}