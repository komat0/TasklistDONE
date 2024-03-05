fun main() {
    val arrSize = readLine()!!.toInt()
    var newArray = IntArray(arrSize)

    repeat(arrSize) {
        newArray += readLine()!!.toInt()
    }

    val m = readLine()!!.toInt()
    println(if (newArray.contains(m)) "YES" else "NO")
}