package kit

import java.util.LinkedList
import java.util.Queue

fun main() {
    solution(
        3, computers = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1),
        )
    ).also { println(it) }
}

private fun solution(n: Int, computers: Array<IntArray>): Int {
    var ans = 0
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = Array(n + 1) { false }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) continue
            if (computers[i][j] == 1) {
                graph[i].add(j)
                graph[j].add(i)
            }
        }
    }


    for (i in 0 until n) {
        if (visited[i]) continue
        ans += bfs(graph, i, visited)
    }
    return ans
}

private fun bfs(graph: Array<MutableList<Int>>, start: Int, visited: Array<Boolean>): Int {
    val q: Queue<Int> = LinkedList<Int>()
    q.add(start)
    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (node in graph[cur]) {
            if (!visited[node]) {
                q.add(node)
                visited[node] = true
            }
        }
    }
    return 1
}

private fun solution2(n: Int, computers: Array<IntArray>): Int {
    var ans = 0
    var visited = booleanArrayOf()
    for (i in 0 until n)
        visited += false // wow!! 그런데 어레이 새로 만들어야해서 별로.

    for (i in 0 until n){
        if (!visited[i]){
            ans += 1
            dfs(i, computers, n, visited)
        }
    }
    return ans
}

private fun dfs(start: Int, computers: Array<IntArray>, n: Int, visited: BooleanArray) {
    visited[start] = true
    for (i in 0 until n){
        if (!visited[i] && computers[start][i] == 1)
            dfs(i, computers, n, visited)
    }

}