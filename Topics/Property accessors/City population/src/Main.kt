class City(val name: String) {
    var population: Int = 0
        set(value) {
            val range = 0..50000000
            field = value.coerceIn(range)
        }
}