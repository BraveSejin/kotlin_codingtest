package thisiscodingtest.part2.c10

import java.util.LinkedList
import kotlin.math.max
import kotlin.math.min


fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val indegree = Array(n + 1) { 0 }
    val time = Array(n + 1) { 0 }


    for (i in 1..n) {
        val line = readln().split(" ").map { it.toInt() }
        time[i] = line[0]
        if (line.size > 2) {
            time[i] = line[0]
            for (k in 1..line.lastIndex - 1) {
                indegree[i] += 1
                graph[line[k]].add(i)
            }
        }
    }
    val result = time.copyOf()


    val queue = LinkedList<Int>()

    for (i in 1..n) {
        if (indegree[i] == 0) {
            queue.add(i)
        }

    }

    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()
        for (nearNode in graph[now]) {
            result[nearNode] = max(result[nearNode], result[now] + time[nearNode])
            indegree[nearNode] -= 1
            if (indegree[nearNode] == 0)
                queue.add(nearNode)
        }
    }

    println(result.drop(1).toList())
}