package cheetsheet

import java.util.*
import kotlin.Comparator

/**
 *
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */


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
            o1.second - o2.second
        })
        pq.offer(Pair(start, 0))
        distance[start] = 0
        while (pq.isNotEmpty()) {
            val (curNode, curDist) = pq.poll()
            if (distance[curNode] < curDist) continue // 처리된 적이 있는 노드.

            for ((dest, cost) in graph[curNode]) {
                val newCost = curDist + cost
                if (newCost < distance[dest]) {
                    distance[dest] = newCost
                    pq.offer(Pair(dest, newCost))
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

fun main() {
    dajik_eff_ex()
}