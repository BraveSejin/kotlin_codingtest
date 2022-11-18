package programmers.etcs

import java.util.PriorityQueue
import kotlin.math.max


fun main() {
    val n = 6
    val paths = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(2, 3, 5),
        intArrayOf(2, 4, 2),
        intArrayOf(2, 5, 4),
        intArrayOf(3, 4, 4),
        intArrayOf(4, 5, 3),
        intArrayOf(4, 6, 1),
        intArrayOf(5, 6, 1)

    )
    val gates = intArrayOf(1, 3)
    val summits = intArrayOf(5)
    val res = Sol().solution(n, paths, gates, summits).toList()
    println(res)
}

class Sol {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        val graph = List<MutableList<Pair<Int, Int>>>(n + 1) {
            mutableListOf<Pair<Int, Int>>()
        }
        val INF = 10000001
        val intensities = IntArray(n + 1) { INF }
        paths.forEach {
            val (src, dest, cost) = it
            graph[src].add(Pair(dest, cost))
            graph[dest].add(Pair(src, cost))
        }
        val pq = PriorityQueue(Comparator<Pair<Int, Int>> { o1, o2 -> o1.first - o2.second })
        gates.forEach {
            pq.add(Pair(0, it))
            intensities[it] = 0
        }

        while (pq.isNotEmpty()) {
            val (curIntensity, curNode) = pq.poll()
            if (curIntensity > intensities[curNode] || summits.contains(curNode)) continue

            graph[curNode].forEach { edge ->
                val (nearNode, cost) = edge
                val newIntensity = max(cost, curIntensity)
                if (intensities[nearNode] > newIntensity) {
                    intensities[nearNode] = newIntensity
                    pq.add(Pair(newIntensity, nearNode))
                }
            }
            intensities[curNode] = curIntensity
        }
        var minSummitAndIntensity = Pair(0, INF)
        summits.sort()
        summits.forEach { summit ->
            if (intensities[summit] < minSummitAndIntensity.second) {
                minSummitAndIntensity = Pair(summit, intensities[summit])
            }
        }

        val answer: IntArray = intArrayOf(minSummitAndIntensity.first, minSummitAndIntensity.second)
        return answer
    }
}