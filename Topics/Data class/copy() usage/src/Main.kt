// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    // implement your code here
    val height = readln().toInt()
    val length = readln().toInt()
    val secondBox = readln().toInt()
    val width = readln().toInt()

    val box = Box(height, length, width)
    val box2 = box.copy(length = secondBox)
    println(box)
    println(box2)
}