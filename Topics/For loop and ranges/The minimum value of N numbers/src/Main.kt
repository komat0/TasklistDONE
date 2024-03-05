fun main() {
    val inputSize = readln().toInt()
    val inputList = mutableListOf<Int>()
    var minDigit = Int.MAX_VALUE

    repeat(inputSize) {
        inputList.add(readln().toInt())
    }

    for (element in inputList) {
if (element < minDigit) minDigit = element
    }
    println(minDigit)
}