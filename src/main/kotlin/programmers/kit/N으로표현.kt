package programmers.kit

import kotlin.math.min

fun main() {

}

private fun solution(N: Int, number: Int): Int {
    val dp = IntArray(number + 1) { 0 }
    dp[0] = 2
    for (i in 1 until N) {
        dp[i] = 2 * i
    }
    dp[N] = 1
    for (i in N + 1..number) {
        dp[i] = dp[i - N] + 1
        dp[i] = dp[i / N]
    }


    var answer = 0
    return answer
}