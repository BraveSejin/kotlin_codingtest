package cheetsheet

private val INF: Int = 100000000
private var n = 0
private var m = 0
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var visited: BooleanArray
private lateinit var distance: IntArray

private fun simpleDajik(
    startVertex: Int
) {
    distance[startVertex] = 0
    visited[startVertex] = true

    for ((dest, cost) in graph[startVertex])
        distance[dest] = cost
    for (_i in 0 until n - 1) {
        val now = getSmallestNode()
        visited[now] = true
        println("visited: $now")
        for ((dest, cost) in graph[now]) {
            val nCost = distance[now] + cost
            if (nCost < distance[dest])
                distance[dest] = nCost
        }
    }

}

private fun getSmallestNode(): Int {
    var min_value: Int = INF
    var idx = 0
    for (i in 1 until n + 1) {
        if (visited[i]) continue
        if (distance[i] < min_value) {
            min_value = distance[i]
            idx = i
        }
    }
    return idx
}

fun main() = with(System.`in`.bufferedReader()) {
    // vertex, edge
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    val start = readLine().toInt()
    graph = Array(n + 1) {
        mutableListOf<Pair<Int, Int>>()
    }
    visited = BooleanArray(n + 1) { false }
    distance = IntArray(n + 1) { INF.toInt() }

    for (i in 0 until m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }

    simpleDajik(start)

    for (i in 1 until n+1){
        if (distance[i] == INF) println("INFINITY")
        else print(distance[i])
    }
}

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