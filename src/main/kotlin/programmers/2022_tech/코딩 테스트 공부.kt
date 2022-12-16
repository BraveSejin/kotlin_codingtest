
import kotlin.math.max
import kotlin.math.min

private class Solution123 {
    @Suppress("NAME_SHADOWING")
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        var (alp,cop) = alp to cop
        val alpTarget = max(problems.map { it[0] }.maxOf { it }, alp)
        val copTarget = max(problems.map { it[1] }.maxOf { it }, cop)
        val dp = Array( alpTarget + 1) { IntArray(copTarget + 1) { 300 } }
        for (i in 0..alp) {
            for (j in 0..cop) {
                dp[i][j] = 0
            }
        }
        for (i in alp .. alpTarget){
            for (j in cop .. copTarget){
                if (i < alpTarget)
                    dp[i+1][j] = min(dp[i+1][j], dp[i][j] + 1)
                if (j < copTarget)
                    dp[i][j+1] = min(dp[i][j+1], dp[i][j] + 1)

                for ((alpReq, copReq, alpRwd, copRwd, cost) in problems){
                    if (i >= alpReq && j >= copReq){
                        val newAlp = min(i+ alpRwd, alpTarget)
                        val newCop = min(j + copRwd, copTarget)
                        dp[newAlp][newCop] = min(dp[newAlp][newCop], dp[i][j] + cost)
                    }
                }
            }
        }


        return dp[alpTarget][copTarget]
    }
}