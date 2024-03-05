fun iterator(map: Map<String, Int>) {
    for (m in map) {
        if (m.value % 3 == 0) println("Fizz")
        else if (m.value % 5 == 0) println("Buzz")
        else println("FizzBuzz")
    }
}