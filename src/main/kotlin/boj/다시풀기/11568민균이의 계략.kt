package boj.다시풀기

import kotlin.math.max


fun main() {
    // 순증가하는 수열의 최대크기
    민균이의_계략().execute()
}

private class 민균이의_계략() {
    lateinit var data: List<Int>
    fun execute() {
        val N = readln().toInt()
        val dp = IntArray(N)
        data = readln().split(" ").map { it.toInt() }

        for (i in data.indices) {
            dp[i] = 1
            for (j in 0 until i) {
                if (dp[i] < dp[j] + 1 && data[i] > data[j])
                    dp[i] = dp[j] + 1
            }
        }
        println(dp.maxOf { it })
    }


}