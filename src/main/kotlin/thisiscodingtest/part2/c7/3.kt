package thisiscodingtest.part2.c7

import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val data = readln().split(" ").map { it.toInt() }

    // 자르고 남은길이가 M 이상이어야 한다.
    // 나머지가 M 이상인 지점을 차자.
    var start = 0
    var end = data.maxOf { it -> it }
    var mid = (start + end) / 2
    var maxHeight = 0
    while (start <= end) {
        val remainder = data.minusAndGetRemainder(mid)
        if (remainder >= m) {
            maxHeight = max(maxHeight, mid)
            start = mid + 1
        } else {
            end = mid - 1
        }
        mid = (start + end) / 2
    }
    println(maxHeight)
}

private fun List<Int>.minusAndGetRemainder(v: Int): Int {
    return this.map { it -> it - v }.filter { it > 0 }
        .sum()
}