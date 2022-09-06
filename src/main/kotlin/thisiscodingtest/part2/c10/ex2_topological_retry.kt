package thisiscodingtest.part2.c10

import java.util.*

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val indegree = Array(v + 1) { 0 }
    val graph = Array(v + 1) { mutableListOf<Int>() }

    for (i in 1..e) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        indegree[b] += 1
    }

    var removedNode = mutableListOf<Int>()
    val q = LinkedList<Int>()

    for (i in 1..v) {
        if (indegree[i] == 0) q.add(i)
    }

    while (q.isNotEmpty()) {
        val now = q.pop()
        removedNode.add(now)
        for (node in graph[now]) {
            indegree[node] -= 1
            if (indegree[node] == 0)
                q.add(node)
        }
    }
    println(removedNode)

}