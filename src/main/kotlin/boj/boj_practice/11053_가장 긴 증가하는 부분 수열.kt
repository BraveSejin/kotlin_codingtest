package boj.boj_practice

fun main() {
    val N = readln().toInt()
    val data = readln().split(" ").map { it.toInt() }
    val dp = IntArray(N)
    for (i in 0 until N){
        dp[i] = 1
        for (j in 0 until i){
            if (data[j] < data[i] && dp[j] + 1 > dp[i]){
                dp[i] = dp[j] + 1
            }
        }
    }
    println(dp.maxOf { it })
}