fun intsToSet(ints: MutableList<Int>): Set<Int> {

    val newSet = mutableSetOf<Int>()
    for (i in ints) newSet.add(i)
    return newSet
}