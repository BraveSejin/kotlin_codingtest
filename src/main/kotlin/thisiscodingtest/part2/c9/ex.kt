package thisiscodingtest.part2.c9

import java.util.PriorityQueue
import kotlin.math.min


fun main() {
//    dajik_simple_ex()
//    dajik_eff_ex()
    floyd_warshall()
}

private fun dajik_simple_ex() {
    val INF = Integer.MAX_VALUE
    val reader = System.`in`.bufferedReader()
    // node, edge 개수
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    val start = reader.readLine().toInt()
    val graph = Array(n + 1) {
        mutableListOf<Pair<Int, Int>>()
    }
    val visited = Array(n + 1) { false }
    val distance = Array(n + 1) { INF }


    repeat(m) {
        val (src, dest, cost) = reader.readLine().split(" ").map { it.toInt() }
        graph[src].add(Pair(dest, cost))
    }
    fun smallest_node(): Int {
        var min_cost = INF
        var min_index = 0
        for (i in 1..n) {
            if (distance[i] < min_cost && !visited[i]) {
                min_cost = distance[i]
                min_index = i
            }
        }
        return min_index
    }


    fun dajik_simple(start: Int) {
        distance[start] = 0
        visited[start] = true
        for ((dest, cost) in graph[start]) { // 시작과 인접한 노드 거리 초기화
            distance[dest] = cost
        }
        repeat(n - 1) { // 나머지 노드 n-1번 찾아서 반복
            val now = smallest_node()
            visited[now] = true
            for ((dest, cost) in graph[now]) {
                val newDist = distance[now] + cost
                if (newDist < distance[dest])
                    distance[dest] = newDist
            }
        }

    }

    dajik_simple(start)
    distance.takeLast(distance.size - 1).forEach { it ->
        if (it == INF) println("INF")
        else println(it)
    }
}

private fun dajik_eff_ex() {
    val INF = Integer.MAX_VALUE
    val reader = System.`in`.bufferedReader()
    // node, edge 개수
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    val start = reader.readLine().toInt()
    val graph = Array(n + 1) {
        mutableListOf<Pair<Int, Int>>()
    }
    repeat(m) {
        val (src, dest, cost) = reader.readLine().split(" ").map { it.toInt() }
        graph[src].add(Pair(dest, cost))
    }
    val distance = Array(n + 1) { INF }

    fun dajik(start: Int) {
        val pq = PriorityQueue(Comparator<Pair<Int, Int>> { o1, o2 ->
            o1.first - o2.first
        })
        pq.offer(Pair(0, start))
        distance[start] = 0
        while (pq.isNotEmpty()) {
            val (curDist, curNode) = pq.poll()
            if (distance[curNode] < curDist) continue // 처리된 적이 있는 노드.

            for ((dest, cost) in graph[curNode]) {
                val newCost = curDist + cost
                if (newCost < distance[dest]) {
                    distance[dest] = newCost
                    pq.offer(Pair(newCost, dest))
                }
            }
        }
    }
    dajik(start)

    distance.takeLast(distance.size - 1).forEach { it ->
        if (it == INF) println("INF")
        else println(it)
    }

}

private fun floyd_warshall() {
    val n = readln().toInt()
    val m = readln().toInt() // edge 개수
    val graph = Array(n + 1) {
        Array(n + 1) {
            100000
        }
    }

    for (a in 1..n) {
        for (b in 1..n)
            if (a == b)
                graph[a][b] = 0
    }

    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a][b] = c
    }

    for (k in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }

    graph.forEach {
        println(it.toList())
    }
}