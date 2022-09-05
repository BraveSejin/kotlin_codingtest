package thisiscodingtest.part2.c8

import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val coins = mutableListOf<Int>().apply { add(0) }
    repeat(n) {
        coins.add(readln().toInt())
    }

    val dp = Array(m + 1) { 10001 }
    dp[0] = 0

    for (coin in coins) {
        for (money in coin..m) {
            if (dp[money - coin] != 10001)
                dp[money] = min(dp[money], dp[money - coin] + 1)
        }
    }


    println(if (dp[m] == 10001) -1 else dp[m])

}