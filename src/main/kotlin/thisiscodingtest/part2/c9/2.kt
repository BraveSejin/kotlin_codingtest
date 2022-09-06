package thisiscodingtest.part2.c9

import java.util.PriorityQueue
import kotlin.math.min

fun main() {
    dajik()
}

private fun dajik() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distance1 = Array(n + 1) { Int.MAX_VALUE }
    val distance2 = Array(n + 1) { Int.MAX_VALUE }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, 1))
        graph[b].add(Pair(a, 1))
    }
    val (x, k) = readln().split(" ").map { it.toInt() }

    val pq = PriorityQueue(Comparator<Pair<Int, Int>> { o1, o2 ->
        o1.first - o2.first
    })
    pq.offer(Pair(0, 1))
    distance1[1] = 0
    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (now.first > distance1[now.second]) continue

        distance1[now.second] = now.first

        for ((node, cost) in graph[now.second]) {
            val newCost = now.first + cost
            if (newCost < distance1[node]) {
                distance1[node] = newCost
                pq.offer(Pair(newCost, node))
            }
        }
    }
    pq.offer(Pair(0, k))
    distance2[k] = 0
    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (now.first > distance2[now.second]) continue

        distance2[now.second] = now.first

        for ((node, cost) in graph[now.second]) {
            val newCost = now.first + cost
            if (newCost < distance2[node]) {
                distance2[node] = newCost
                pq.offer(Pair(newCost, node))
            }
        }
    }

    val res = distance1[k] + distance2[x]
    println( if (res > 100) -1 else res)


}

private fun warshall_floyd() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) {
        Array(n + 1) {
            103
        }
    }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }
    val (x, k) = readln().split(" ").map { it.toInt() }

    for (c in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                graph[a][b] = min(graph[a][b], graph[a][c] + graph[c][b])
            }
        }
    }
    val res = graph[1][k] + graph[k][x]

    println(if (res < 101) res else -1)

}