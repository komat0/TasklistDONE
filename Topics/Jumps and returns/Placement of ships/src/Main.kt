fun main() {
    val seaBattle: Array<Array<Int>> = Array(6) { Array(6) { 0 } }
    var xLine = mutableListOf(1, 2, 3, 4, 5)
    var yLine = mutableListOf(1, 2, 3, 4, 5)
    repeat(3) {
        val userinput = readln()
        val (x, y) = userinput.split(" ").map { it.toInt() }
        seaBattle[x][y] = 1
    }

    for (xIndex in seaBattle[0].indices) {
        for (yIndex in seaBattle.indices) {
            val element = seaBattle[yIndex][xIndex]
            if (element == 1) {
                xLine.remove(xIndex)
                yLine.remove(yIndex)
            }
        }
    }
    println(yLine.joinToString(separator = " "))
    println(xLine.joinToString(separator = " "))
}