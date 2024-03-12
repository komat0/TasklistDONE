fun main() {

    lettersCheck()

}
fun lettersCheck() {
    val userInput = readln().firstOrNull()
    for (i in 'a'..'z') {
        if (i == userInput) return
        print(i)
    }
}