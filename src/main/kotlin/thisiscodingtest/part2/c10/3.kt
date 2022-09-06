package thisiscodingtest.part2.c10

import java.lang.Integer.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val parent = Array(n + 1) { it }
    val edges = Array(m) {
        val (a, b, cost) = readln().split(" ").map { it.toInt() }

        Triple(a, b, cost)
    }

    var res = 0
    var maxCost = 0
    edges.sortWith { o1, o2 -> o1.third - o2.third }

    for (edge in edges) {
        val (a, b, cost) = edge
        if (findParent(parent, a) != findParent(parent, b)) {
            unionParent(parent, a, b)
            res += cost
            maxCost = cost
        }
    }

    println(edges.toList())
    println(parent.toList())

    println(res - maxCost)

}

private fun findParent(parent: Array<Int>, x: Int): Int {
    if (x != parent[x]) {
        parent[x] = findParent(parent, parent[x])
    }
    return parent[x]
}

private fun unionParent(parent: Array<Int>, a: Int, b: Int) {
    val a = findParent(parent,a)
    val b = findParent(parent,b)
    if (a < b) {
        parent[b] = a
    } else {
        parent[a] = b
    }
}