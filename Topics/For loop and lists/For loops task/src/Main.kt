fun main() {
    val inputSize = readln().toInt()
    val inputList = mutableListOf<Int>()

    repeat(inputSize) {
        inputList.add(readln().toInt())
    }

    val (firstDigit, secondDigit) = readLine()!!.split(" ")
    val inputList2 = mutableListOf(firstDigit.toInt(), secondDigit.toInt())
    if (inputList.contains(inputList2[0]) && inputList.contains(inputList2[1])) println("YES") else println("NO")
}