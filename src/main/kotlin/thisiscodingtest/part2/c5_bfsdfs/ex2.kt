package thisiscodingtest.part2.c5_bfsdfs

fun main() {
    matrix()
    aList()
}

private fun matrix() {
    val INF = 99999999
    val graph = arrayOf(
        intArrayOf(0, 7, 5),
        intArrayOf(7, 0, INF),
        intArrayOf(5, INF, 0)
    )
    graph.forEach {
        println(it.toList())
    }
}

// 노드가 3개라면
private fun aList() {
    val INF = 99999999
    val graph = Array(3) {
        mutableListOf<Pair<Int, Int>>()
    }
    graph[0].add(Pair(1,7))
    graph[0].add(Pair(2,5))
    graph[1].add(Pair(0,7))
    graph[2].add(Pair(0,5))
    graph.forEach {
        println(it)
    }
}