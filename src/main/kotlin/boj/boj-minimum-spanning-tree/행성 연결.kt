import kotlin.properties.Delegates

private fun findParent(parent: IntArray, x: Int): Int {
    if (parent[x] != x)
        parent[x] = findParent(parent, parent[x])
    return parent[x]
}

private fun unionParent(parent: IntArray, a: Int, b: Int) {
    val pa = findParent(parent, a)
    val pb = findParent(parent, b)
    if (pa < pb) {
        parent[pb] = pa
    } else {
        parent[pa] = pb
    }
}

fun main() {
    var res: Long = 0

    val n = readln().toInt()

    val parent = IntArray(n) { it }
    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) { i ->

        val costs = readln().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            if (i == j) continue
            edges.add(Triple(i, j, costs[j]))
        }

    }
    edges.sortBy { it.third }
    edges.forEach { edge ->
        val (a, b, c) = edge
        if (findParent(parent, a) != findParent(parent, b)) {
            unionParent(parent, a, b)
            res += c
        }
    }
    println(res)
}