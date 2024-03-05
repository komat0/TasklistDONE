fun main() {
    val inputSize = readln().toInt()
    val inputList = mutableListOf<Int>()
    var sorted = true

    repeat(inputSize) {
        inputList.add(readln().toInt())
    }

    for (i in 0 until inputSize - 1) {
        if (inputList[i] >= inputList[i + 1]) sorted = false
    }
    if (sorted == false) println("NO") else println("YES")
}