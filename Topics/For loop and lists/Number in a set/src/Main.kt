fun main() {
val count = readln().toInt()
    val list = mutableListOf<Int>()
repeat(count){
    list.add(readln().toInt())
}
    val checker = readln().toInt()
    println(if (list.contains(checker)) "YES" else "NO")
}