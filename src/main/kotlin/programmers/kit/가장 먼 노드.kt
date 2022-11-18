package programmers.kit

import java.util.PriorityQueue

fun main() {
    solution(
        6, arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2),
        )
    ).also { println(it) }
}


private fun solution(n: Int, edge: Array<IntArray>): Int {

    val distance = Array(n + 1) { 50001 }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    edge.forEach { it ->
        graph[it[0]].add(it[1])
        graph[it[1]].add(it[0])
    }
    val pq = PriorityQueue(Comparator<Pair<Int, Int>> { o1, o2 ->
        o1.first - o2.first
    })

    pq.offer(Pair(0, 1))
    distance[1] = 0

    while (pq.isNotEmpty()) {
        val (curDist, curNode) = pq.poll()
        if (distance[curNode] < curDist) continue
        for (dest in graph[curNode]) {
            val newCost = curDist + 1
            if (newCost < distance[dest]) {
                distance[dest] = newCost
                pq.offer(Pair(newCost, dest))
            }
        }
    }
    val farDistance = distance.filter { it != 50001 }.maxOf { it }
    val targets = distance.filter{ it == farDistance }
    return targets.size


}