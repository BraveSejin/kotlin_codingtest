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

    val (n, m) = readln().split(" ").map { it.toInt() }
    val parentWorst = IntArray(n + 1) { it }
    var ascWorst = 0
    val parentBest = IntArray(n + 1) { it }
    var ascBest = 0
    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(m + 1) {
        readln().split(" ").map { it.toInt() }.let {
            edges.add(Triple(it[0], it[1], it[2]))
        }
    }

    if (edges.first().third == 0) {
        ascWorst = 1
        ascBest = 1
    }
    unionParent(parentWorst, 0, 1)



    edges.sortBy { it.third }

    for (edge in edges) {
        if (findParent(parentWorst, edge.first) != findParent(parentWorst, edge.second)) {
            unionParent(parentWorst, edge.first, edge.second)
            if (edge.third == 0) {
                ascWorst += 1
            }
        }
    }

    unionParent(parentBest, 0, 1)

    edges.sortByDescending { it.third }

    for (edge in edges) {
        if (findParent(parentBest, edge.first) != findParent(parentBest, edge.second)) {
            unionParent(parentBest, edge.first, edge.second)
            if (edge.third == 0) {
                ascBest += 1
            }
        }
    }

    println(ascWorst.times(ascWorst) - ascBest.times(ascBest))

}