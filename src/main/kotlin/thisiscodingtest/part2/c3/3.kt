package thisiscodingtest

import java.lang.Integer.max

fun main() {

}

private fun sol1() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val data = Array(N) { idx ->
        readln().split(" ").map { it.toInt() }.sorted().first()
    }.toList().sorted()

    print(data.last())
}

private fun sol2() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    var res = 0
    repeat(N) {
        res = max(readln().split(" ").map { it.toInt() }.min(), res)
    }
    println(res)
}


/*
* 3 3
* 3 1 2
* 4 1 4
* 2 2 2
*
* */

