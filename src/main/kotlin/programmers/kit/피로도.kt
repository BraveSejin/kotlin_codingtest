package programmers.kit

import kotlin.math.max

fun main() {
    solution(
        80, arrayOf(
            intArrayOf(80, 20),
            intArrayOf(50, 40),
            intArrayOf(30, 10),
        )
    ).also { println(it) }
}

private var ans = 0
private fun solution(k: Int, dungeons: Array<IntArray>): Int {


    val checked = BooleanArray(dungeons.size) { false }
    dfs(k, dungeons, checked, 0)

    return ans
}

private fun dfs(k: Int, dungeons: Array<IntArray>, checked: BooleanArray, cnt: Int) {
    for (i in dungeons.indices) {
        if (k >= dungeons[i][0] && !checked[i]) {
            checked[i] = true
            dfs(k - dungeons[i][1], dungeons, checked, cnt + 1)
            checked[i] = false
        }
    }
    ans = max(ans, cnt)
}
