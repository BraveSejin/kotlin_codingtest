package kit

import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.min

// 하나를 와이어 하나를 끊은 모든 그래프를 구하고, 각각의 너비차를 bfs로 구한다. 그중 최소를 취한다.

fun main() {
    solution(
        9, arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(4, 6),
            intArrayOf(4, 7),
            intArrayOf(7, 8),
            intArrayOf(7, 9),
        )
    ).also { println(it) }
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


private fun solution(n: Int, wires: Array<IntArray>): Int {


    var answer: Int = 103

    wires.indices.forEach { idx ->
        val parent = Array(n + 1) { idx -> idx } // 부모 테이블 초기화
        val visited = BooleanArray(n + 1) { false }
        val cntList = mutableListOf<Int>()
        wires.forEachIndexed { idx2, wire ->
            if (idx != idx2) {
                val (src, dest) = Pair(wire[0], wire[1])
                unionParent(parent, src, dest)
            }
        }

        val parentList = mutableListOf<Int>().apply {
            for (i in 1..n) {
                add(findParent(parent, i))
            }
        }
        val parentSet = parentList.toHashSet().toList()
        answer = min(abs(parentList.count { it == parentSet[0] } - parentList.count { it == parentSet[1] }), answer)

    }

    return answer
}
