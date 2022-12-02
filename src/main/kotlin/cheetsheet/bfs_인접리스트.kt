package cheetsheet

import java.util.LinkedList

/***
5 6
101010
111111
000001
111111
111111
 */

private val graph = arrayOf(
    intArrayOf(),
    intArrayOf(2, 3, 8),
    intArrayOf(1, 7),
    intArrayOf(1, 4, 5),
    intArrayOf(3, 5),
    intArrayOf(3, 4),
    intArrayOf(7),
    intArrayOf(2, 6, 8),
    intArrayOf(1, 7),
)

private val visited = BooleanArray(9) { false }

private fun bfs(graph: Array<IntArray>, start: Int, visited: BooleanArray) {

    val queue = LinkedList<Int>()
    queue.offer(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        print("$cur, ")
        for (node in graph[cur]) {
            if (!visited[node]) {
                queue.offer(node)
                visited[node] = true
            }
        }
    }
}

fun main() {
    bfs(graph, 1, visited)
}