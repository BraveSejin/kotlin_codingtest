package kit

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
private var checked = mutableListOf<Boolean>()

private fun solution(k: Int, dungeons: Array<IntArray>): Int {

    checked.addAll(MutableList(k) { false })
    dfs(k, dungeons, 0)

    return ans
}

private fun dfs(k: Int, dungeons: Array<IntArray>, cnt: Int) {


    for (i in dungeons.indices) {
        if (!checked[i] && dungeons[i][0] <= k) {
            checked[i] = true
            dfs(k - dungeons[i][1], dungeons, cnt + 1)
            checked[i] = false
        }
    }
    ans = max(ans, cnt)

}
