package thisiscodingtest.part2.c8

fun main() {
    val height = 2
    val width = readln().toInt()

    val dp = Array(width + 1) { 0 }

    // 가로의 길이가 i 일때 모든경우의수
    dp[0] = 0
    dp[1] = 1 // b
    dp[2] = 3

    for (i in 3..width) {
        dp[i] = dp[i-1] + dp[i-2] * 2
    }
    println(dp[width] % 796796)

}