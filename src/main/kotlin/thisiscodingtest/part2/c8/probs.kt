import java.lang.Integer.max
import java.util.Collections
import kotlin.math.min

fun main() {
//    make1()
    ant()
}

private fun make1() {
    val X = readln().toInt()
    var res = 0
    val dp = Array(X + 1) { 0 }

    dp[1] = 0

    for (i in 2..X) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0)
            dp[i] = min(dp[i], dp[i / 3] + 1)
        if (i % 3 == 0)
            dp[i] = min(dp[i], dp[i / 3] + 1)
        if (i % 5 == 0)
            dp[i] = min(dp[i], dp[i / 5] + 1)
    }

    println(dp[X])

}

private fun ant() {
    val n = readln().toInt()
    val data = mutableListOf<Int>(0).apply {
        addAll(readln().split(" ").map { it.toInt() })
    }
    val dp = Array(n + 1) { 0 }
    dp[0] = 0
    dp[1] = data[1]
    for (i in 2..n) {
        dp[i] = max(dp[i - 1], dp[i - 2] + data[i])
    }

    println(dp.maxOf { it })
}