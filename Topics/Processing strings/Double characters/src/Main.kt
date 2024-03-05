fun main() {
    val input = readln()
    var newString = ""
    for (i in input) {
        newString += i + i.toString()
    }
    println(newString)
}