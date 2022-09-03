package thisiscodingtest

fun main() {
    val coins = arrayOf(500, 100, 50, 10)
    var N = 1260
    var count = 0
    coins.forEach { coin ->
        count += N / coin
        N %= coin
    }
    println(count)
}