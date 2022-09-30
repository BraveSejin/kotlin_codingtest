package kit

private fun findParent(parent: Array<Int>, x: Int): Int {
    if (parent[x] != x)
        parent[x] = findParent(parent, parent[x])
    return parent[x]
}

private fun unionParent(parent: Array<Int>, a: Int, b: Int) {
    val a = findParent(parent, a)
    val b = findParent(parent, b)

    if (a < b) {
        parent[b] = a
    } else { // a >= b
        parent[a] = b
    }
}

fun main() {
    solution(
        4, arrayOf(
            intArrayOf(1, 2, 5),
            intArrayOf(1, 3, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 2),
            intArrayOf(2, 3, 8)
        )
    ).also { println(it) }

}

private fun solution(n: Int, costs: Array<IntArray>): Int {
    var ans = 0
    val parent = Array(n + 1) { idx -> idx }

    costs.sortWith { o1, o2 -> o1[2] - o2[2] }
    costs.forEach {
        val (from, to, cost) = it
        println(cost)
        if (findParent(parent, from) != findParent(parent, to)) {
            unionParent(parent, from, to)
            ans += cost
        }
    }
//    costs.forEach { it ->
//        val (from,to,cost) = it
//        )
//        graph.add(Triple(cost,from,to))
//    }


    return ans
}