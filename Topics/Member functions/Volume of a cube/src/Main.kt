class Box(var height: Double, var width: Double, var length: Double) {

fun getVolume(): Double {
    val s = (height * width * length)
    return s
}
}