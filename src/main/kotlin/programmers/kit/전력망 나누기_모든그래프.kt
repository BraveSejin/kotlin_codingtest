package programmers.kit

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

private fun solution(n: Int, wires: Array<IntArray>): Int {
    var answer: Int = 103
//    for (i in wires.indices) {
    for (i in 0 until wires.size) {
        val newWires = wires.toMutableList().apply { removeAt(i) }.toTypedArray()
        val newGraph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
        for (wire in newWires) {
            newGraph[wire[0]].add(wire[1])
            newGraph[wire[1]].add(wire[0])
        }
        answer = min(diff(n, newGraph), answer)

    }
    return answer
}

private fun diff(n: Int, graph: Array<MutableList<Int>>): Int {
    // bfs 두번 돌린다.


    val towerNumList = mutableListOf<Int>()
    var tries = 2
    val visited = BooleanArray(n + 1) { false }
    for (i in 1..graph.size - 1) {
        if (visited[i]) continue

        if (tries == 0) break
        tries -= 1


        val q = LinkedList<Int>()
        q.add(i)
        visited[i] = true
        var towerNum = 0
        while (q.isNotEmpty()) {

            val cur = q.poll()
            for (node in graph[cur]) {
                if (visited[node]) continue
                towerNum += 1
                q.add(node)
                visited[node] = true
            }
        }

        towerNumList.add(towerNum)
    }
//    println(towerNumList)
    return abs(towerNumList[0] - towerNumList[1])

}

