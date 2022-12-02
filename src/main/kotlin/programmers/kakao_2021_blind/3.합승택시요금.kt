package programmers.kakao_2021_blind

import java.lang.Math.min


fun main() {
    solution(7,3,4,1, arrayOf(
        intArrayOf(5,7,9),
        intArrayOf(4,6,4),
        intArrayOf(3,6,1),
        intArrayOf(3,2,3),
        intArrayOf(2,1,6),
    ))
}
private val INF = 201*100_001

private fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
    val graph = Array(n + 1) { Array(n + 1) { INF } }
    fares.forEach { fare ->
        val (from, to, fee) = fare
        graph[from][to] = fee
        graph[to][from] = fee
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (i == j) graph[i][j] = 0
                else graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }
    // 중간에 어느 지점에 내린 다음, 거기서 각자 이치로 간다고 생각해보자.
    var ans = INF
    for (i in 1..n) {
//        println("s: $s i: $i a:$a b:$b")
        ans = min(ans, graph[s][i] + graph[i][a] + graph[i][b])
//        println(ans)
    }

    return ans
}