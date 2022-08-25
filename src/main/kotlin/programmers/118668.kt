import kotlin.math.max
import kotlin.math.min


class Solution2 {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val maxAlp = max(problems.maxWithOrNull() { o1:IntArray , o2:IntArray -> o1[0] - o2[0] }!![0], alp)
        val maxCop = max(problems.maxWithOrNull() { o1 :IntArray, o2 :IntArray -> o1[1] - o2[1] }!![1], cop)
        if (maxAlp <= alp && maxCop <= cop) return 0
        val dp = Array(maxAlp + 1) { IntArray(maxCop + 1) { 99999 } }
        dp[alp][cop] = 0
        for (i in alp..maxAlp) for (j in cop..maxCop) {
            if (i + 1 <= maxAlp) dp[i+1][j] = min(dp[i+1][j], dp[i][j]+1)
            if (j + 1 <= maxCop) dp[i][j+1] = min(dp[i][j+1], dp[i][j]+1)
            for (problem in problems){
                val (alp_req, cop_req, alp_rwd, cop_rwd, cost) = problem
                if (alp_req <= i && cop_req <= j){
                    val ni = min(i+alp_rwd, maxAlp)
                    val nj = min(j+cop_rwd,maxCop)
                    dp[ni][nj] = min(dp[ni][nj], dp[i][j] + cost)
                }
            }

        }

        return dp[maxAlp][maxCop]
    }
}

fun main() {
    val problems = arrayOf(intArrayOf(10, 15, 2, 1, 2), intArrayOf(20, 20, 3, 3, 4))
    val sol = Solution2().solution(10, 10, problems)
    print(sol)
}