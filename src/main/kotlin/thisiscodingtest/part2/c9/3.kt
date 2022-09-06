package thisiscodingtest.part2.c9

import java.util.PriorityQueue

fun main() {
    val INF = 1_003
    val (n, m, c) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distance = Array(n + 1) { INF }

    repeat(m) {
        val (x, y, z) = readln().split(" ").map { it.toInt() }
        graph[x].add(Pair(y, z))
    }

    val start = c

    val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        o1.first - o2.first
    }
    distance[start] = 0
    pq.add(Pair(0, start))

    while (pq.isNotEmpty()) {
        val (cCost, cNode) = pq.remove()
        if (cCost > distance[cNode]) continue

        for ((node, cost) in graph[cNode]) {
            val newCost = distance[cNode] + cost
            if (newCost < distance[node]) {
                distance[node] = newCost
                pq.add(Pair(newCost, node))
            }
        }
    }
    val reachable = distance.filter { it != INF }
    println("${reachable.count() - 1} ${reachable.maxOf { it }}")


}