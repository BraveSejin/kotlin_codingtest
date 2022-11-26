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
    var ans = 0
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val powers = readln().split(" ").map { it.toInt() }.toSet()
    val parent = IntArray(n + 1) { it }
    powers.forEach { unionParent(parent, 0, it) }
    val edges = Array<Triple<Int, Int, Int>>(m) {
        readln().split(" ").map { it.toInt() }
            .let { Triple(it[0], it[1], it[2]) }
    }.sortedBy { it.third }
    for (edge in edges) {
        if (findParent(parent, edge.first) != findParent(parent, edge.second)) {
            ans += edge.third
            unionParent(parent,edge.first, edge.second)
        }
    }
    println(ans)

    // 발전소, 전력망이 닿는 곳

}
// 발전소들을 가상의 노드에 연결시킨다음,

// 전력망에 인접한 도시들을 먼저 연결하는 경우 until 모든 도시가 전력망 연결
// xor 로 필요한 경우만 연결하는게 포인트 (발전소랑, 이미 전력이 있는 도시 연결 필요 x)
//fun main() {
//    var ans = 0
//    val (n, m, k) = readln().split(" ").map { it.toInt() }
//    val powers = mutableSetOf<Int>() // 발전소, 전력망이 닿는 곳
//    powers.addAll(readln().split(" ").map { it.toInt() })
//    val edges = Array<Triple<Int, Int, Int>>(m) {
//        readln().split(" ").map { it.toInt() }
//            .let { Triple(it[0], it[1], it[2]) }
//    }
//    edges.sortBy { it.third }
//
//    val parent = IntArray(n + 1) { it }
//    // 전력망이 연결된 엣지중에 가장 싼거
//    while (powers.count() != n) {
//        val edge = edges.asSequence()
//              // 발전소 간 연결, 발전소 - 전력있는 도시 연결 제외
//            .filter { (it.first in powers).xor(it.second in powers) }
//            .firstOrNull() ?: continue
//        unionParent(parent, edge.first, edge.second)
//        powers.add(edge.first)
//        powers.add(edge.second)
//        ans += edge.third
//    }
//    println(ans)
//
//}