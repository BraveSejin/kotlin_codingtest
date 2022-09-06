package thisiscodingtest.part2.c10

fun main() {

    //부모 테이블:

//    unionEx()
//    cycleEx()
//    kruskalEx()
}

private fun kruskalEx() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val parent = Array(v + 1) { idx -> idx } // 부모 테이블 초기화

    var sum = 0
    var edges = mutableListOf<Triple<Int, Int, Int>>().apply {
        repeat(e) {
            val (a, b, cost) = readln().split(" ").map { it.toInt() }
            add(Triple(cost, a, b))
        }
    }

    edges.sortWith(comparator = { o1, o2 ->
        o1.first - o2.first
    })

    for (edge in edges) {
        val (cost, a, b) = edge
        if (findParent(parent, a) != findParent(parent, b)) {
            unionParent(parent, a, b)
            sum += cost
        }

    }
    println(sum)

}

private fun cycleEx() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val parent = Array(v + 1) { idx -> idx } // 부모 테이블 초기화

    var cycle = false
    for (i in 1..e) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (findParent(parent, a) == findParent(parent, b)) {
            cycle = true
            break
        } else {
            unionParent(parent, a, b)
        }

    }
    //
    println(if (cycle) "사이클 발생" else "no cycle")
}

private fun unionEx() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val parent = Array(v + 1) { idx -> idx } // 부모 테이블 초기화

    for (i in 1..e) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        unionParent(parent, a, b)
    }
    //
    print("각 원소가 속한 집합 ")
    for (i in 1..v) {
        print("${findParent(parent, i)}")
    }
    parent.drop(1).also {
        print("부모 테이블: $it")
    }
}

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

