fun main() {
    var count = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(count) {
        list.add(readln().toInt())
    }
    count = 0
    val checker = readln().toInt()
    for (l in list) {
        if (l == checker) count++
    }
    println(count)
}