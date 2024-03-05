fun printIfPrime(number: Int) {
    var flag = true
    for (i in 1 until number) {
        if (number % i == 0 && i != 1) {
            flag = false
            break
        }
    }
    if (flag) {
        println("$number is a prime number.")
    } else {
        println("$number is not a prime number.")
    }
}

fun main(args: Array<String>) {
    val number = readLine()!!.toInt()
    printIfPrime(number)
}