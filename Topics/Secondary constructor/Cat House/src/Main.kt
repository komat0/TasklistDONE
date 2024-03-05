class Kitty {
    var name: String = ""
    var color: Int = 0

    constructor(name: String, color: Int) {
        this.name = name
        this.color = color
    }
    constructor(color: Int, name: String) {
        this.color = color
        this.name = name
    }
    constructor(name: String) {
        this.name = name
    }
    constructor(color: Int) {
        this.name = name
        this.color = color
    }
}