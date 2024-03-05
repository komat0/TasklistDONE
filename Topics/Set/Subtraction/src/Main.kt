fun solution(numbers1: Set<Int>, numbers2: Set<Int>): Int {
    val newSet = numbers1-numbers2
    return newSet.size
}