fun main() {
    val input = readln()
    var first = 0
    var second = 0
    for (i in 0 until 3) {
        first += input[i].digitToInt()
    }
    for (i in (input.length - 3)until (input.length)) {
        second += input[i].digitToInt()
}
    println(if (first == second) "Lucky" else "Regular")
}