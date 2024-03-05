fun solution(strings: MutableList<String>): Set<String> {

    val newSet = mutableSetOf<String>()
    for (string in strings) newSet.add(string)
    return newSet
}