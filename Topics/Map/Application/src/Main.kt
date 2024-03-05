fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var counter = 0
    for (i in 0 until shoppingList.size) {
        if (priceList.containsKey(shoppingList[i])) counter+= priceList.getValue(shoppingList[i])
    }
    return counter
}