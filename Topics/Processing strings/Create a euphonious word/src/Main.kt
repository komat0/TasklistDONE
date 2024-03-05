fun main() {
    val input = readln()
    var vowelsCounter = 0
    var consonantsCounter = 0
    var charCounter = 0
    val vowels = "aeiouy"
    for (i in input) {
        if (i in vowels) {
            vowelsCounter++
            consonantsCounter = 0
        } else if (i !in vowels) {
            consonantsCounter++
            vowelsCounter = 0
        }
        if (consonantsCounter == 3) {
            charCounter++
            consonantsCounter = 1
        } else if (vowelsCounter == 3) {
            charCounter++
            vowelsCounter = 1
        }
    }
    println(charCounter)
}