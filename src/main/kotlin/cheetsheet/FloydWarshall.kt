package cheetsheet

import kotlin.math.min

private fun floydWarshall() {
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