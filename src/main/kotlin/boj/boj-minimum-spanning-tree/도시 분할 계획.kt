package boj.`boj-minimum-spanning-tree`

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
    val parent = IntArray(n + 1) { it }

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(m) {
        readln().split(" ").map { it.toInt() }.let {
            edges.add(Triple(it[0], it[1], it[2]))
        }
    }
    edges.sortBy { it.third }
    var cnt = 0
    var res = 0
    for (edge in edges) {
        if (findParent(parent, edge.first) != findParent(parent, edge.second)){
            cnt += 1
            res += edge.third
            unionParent(parent,edge.first,edge.second)
        }
        if (cnt == n-1){
            res -= edge.third
            break
        }
    }
    println(res)

}