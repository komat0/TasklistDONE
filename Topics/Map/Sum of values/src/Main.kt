fun summator(map: Map<Int, Int>): Int {
    var sumCounter = 0
    for ((k, v) in map) {
        if (k % 2 == 0) sumCounter += v
    }
    return sumCounter
}