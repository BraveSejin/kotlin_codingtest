package kit

import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.min

// 하나를 와이어 하나를 끊은 모든 그래프를 구하고, 각각의 너비차를 bfs로 구한다. 그중 최소를 취한다.

fun main() {
    solution(
        9, arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(4, 6),
            intArrayOf(4, 7),
            intArrayOf(7, 8),
            intArrayOf(7, 9),
        )
    ).also { println(it) }
}

private var cnt = 0

private fun solution(n: Int, wires: Array<IntArray>): Int {
    var answer: Int = 103

    wires.indices.forEach { idx ->
        val graph = HashMap<Int, MutableList<Int>>()
        val visited = BooleanArray(n + 1) { false }
        val cntList = mutableListOf<Int>()
        wires.forEachIndexed { idx2, wire ->
            if (idx != idx2) {
                val (src, dest) = Pair(wire[0], wire[1])
                if (!graph.containsKey(src))
                    graph[src] = mutableListOf<Int>()
                if (!graph.containsKey(dest))
                    graph[dest] = mutableListOf<Int>()

                graph[src]!!.add(dest)
                graph[dest]!!.add(src)
            }
        }

        for (i in 1..n) {
            if (!visited[i]) {
                cnt = 0
                dfs(i, graph, visited)
                cntList.add(cnt)
            }
        }
        answer = min(abs(cntList[0] - cntList[1]), answer)

    }

    return answer
}

private fun dfs(from: Int, graph: HashMap<Int, MutableList<Int>>, visited: BooleanArray) {
    if (visited[from]) return
    visited[from] = true
    cnt += 1
    graph[from]?.forEach { to ->
        dfs(to, graph, visited)
    }
}