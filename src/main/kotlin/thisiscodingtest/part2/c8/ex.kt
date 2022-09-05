package thisiscodingtest.part2.c8

fun main() {
    fibo()
}

private fun fibo() {
    val d = Array(100) { 0 }
    d[1] = 1
    d[2] = 1
    for (i in 3..99) {
        d[i] = d[i - 2] + d[i - 1]
    }
    println(d.toList())
}