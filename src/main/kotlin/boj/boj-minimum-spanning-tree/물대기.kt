private fun findParent(parent: IntArray, x: Int): Int {

    if (parent[x] != x)
        parent[x] = findParent(parent, parent[x])
    return parent[x]
}

private fun unionParent(parent: IntArray, x: Int, y: Int) {
    val px = findParent(parent, x)
    val py = findParent(parent, y)
    if (px < py) {
        parent[py] = px
    } else {
        parent[px] = py
    }
}


fun main() {

    var res = 0

    val N = readln().toInt()
    val parent = IntArray(N + 1) { it }
    val diggingCost = IntArray(N + 1) // 우물 팔 때 드는 비용
    repeat(N) {
        diggingCost[it + 1] = readln().toInt()
    } // 이걸 가상의 정점이라고 생각해보자.

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 1..N) {
        val costs = readln().split(" ").map { it.toInt() }
        for (j in 1..N) {
            if (i == j) continue
            edges.add(Triple(i, j, costs[j - 1]))
        }
    }
    for (j in 1..N) {
        edges.add(Triple(0, j, diggingCost[j]))
        edges.add(Triple(j, 0, diggingCost[j]))
    }
    edges.sortBy { it.third }
    var cnt = 0
    edges.forEach {
        if (findParent(parent, it.first) != findParent(parent, it.second)) {
            unionParent(parent, it.first, it.second)
            res += it.third
            cnt += 1
        }
        if (cnt == N) return@forEach
    }
    /**
     * 최소 비용으로 우물을 파거나 연결해야한다.
     * 일단 하나는 파야 한다.
     * digging cost가 가장 낮은 우물을 먼저 파는게 항상 정답인가?
     * 어쩌면 digging cost가 가장 낮은 우물을 파는 것보다, 다른 우물을 판 다음 해당 우물에 연결하는게 싸다고 가정해보자.
     * 어차피 해당 우물까지 접근해야함.
     */

    println(res)


}