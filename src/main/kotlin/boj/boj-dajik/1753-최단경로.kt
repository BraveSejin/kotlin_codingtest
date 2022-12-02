package boj.`boj-dajik`

import java.util.PriorityQueue


fun main() = with(System.`in`.bufferedReader()){
    val (v, e) = readLine().split(" ").map(String::toInt)
    val start = readLine().toInt()
    val graph = Array<MutableList<Pair<Int, Int>>>(v + 1) {
        mutableListOf()
    }
    val distanceTable = IntArray(v + 1) { Integer.MAX_VALUE }
    repeat(e) {
        val (src, dest, w)  = readLine().split(" ").map { it.toInt() }
        graph[src].add(dest to w)
    }
    // 가장 가까운 곳부터 방문한다.
    val pq = PriorityQueue<Pair<Int, Int>>(Comparator { o1, o2 -> o1.second - o2.second })
    pq.add(start to 0)
    distanceTable[start] = 0

    while (pq.isNotEmpty()) {
        val (curNode, curDist) = pq.poll()
        if (distanceTable[curNode] < curDist) continue

        for ((dest, cost) in graph[curNode]) {
            val newCost = cost + curDist
            if (distanceTable[dest] > newCost){
                distanceTable[dest] = newCost
                pq.add((dest to newCost))
            }
        }
    }
    val sb = StringBuilder()
    for (vertex in 1 .. v){
        if (distanceTable[vertex] == Int.MAX_VALUE)
            sb.append("INF\n")
        else
            sb.append("${distanceTable[vertex]}\n")
    }
    println(sb)
}