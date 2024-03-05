fun main() {

    val arrSize = readLine()!!.toInt()
    var newArray = IntArray(arrSize)
    var counter = 0
    var answer = 0
    for (i in 0..arrSize - 1) {
        val nextInt = readLine()!!.toInt()
        newArray += nextInt
        if (nextInt > counter) {
            counter = nextInt
            answer = i
        }
    }
    println(answer)
}
