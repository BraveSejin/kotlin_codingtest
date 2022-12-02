package boj.`boj-dajik`

import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distTable = IntArray(n + 1) { Int.MAX_VALUE }
    val beforeVertex = MutableList<Int>(n + 1) { 0 }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(b to c)
    }
    val (start, end) = readln().split(" ").map { it.toInt() }

    val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 -> p1.second - p2.second }

    pq.add(start to 0)
    distTable[start] = 0

    while (pq.isNotEmpty()) {
        val (nowDest, nowCost) = pq.poll()
        if (distTable[nowDest] < nowCost) continue

        for ((dest, cost) in graph[nowDest]) {
            val newCost = cost + nowCost
            if (newCost < distTable[dest]) {
                beforeVertex[dest] = nowDest
                distTable[dest] = newCost
                pq.add(dest to newCost)
            }
        }
    }

    // beforeVertex를 탐색해본다.

    val ll = LinkedList<Int>()
    var before = end
    while (true){
        // 1 2 3 4
        // 4 3 2 1 ..
        ll.add(0, before)
        if (before == start) break
        before = beforeVertex[before]

    }

    println(distTable[end])
    println(ll.size)
    ll.forEach { print("$it ") }


}