fun main() {
    var counter = 0
    var newArr = IntArray(readLine()!!.toInt())
    for (i in 0..newArr.lastIndex) {
        newArr[i] = readln().toInt()
    }
    for (i in 1..newArr.lastIndex - 1) {
        if (newArr[i - 1] == newArr[i] - 1
            && newArr[i] == newArr[i + 1] - 1) counter++
    }
    println(counter)
}