package examples

private val INF: Int = 100000000
private var n = 0
private var m = 0
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var visited: BooleanArray
private lateinit var distance: IntArray

fun simpleDajik(
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

fun getSmallestNode(): Int {
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