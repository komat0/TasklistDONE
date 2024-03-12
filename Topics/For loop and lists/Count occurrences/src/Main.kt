fun main() {

    val inputSize = readln().toInt()
    val inputList = mutableListOf<Int>()
    var counter = 0

    repeat(inputSize) {
        inputList.add(readln().toInt())
    }
    val inputM = readln().toInt()

    for (element in inputList) {
        if (element == inputM) counter++
    }
    println(counter)
}