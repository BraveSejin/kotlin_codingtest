package programmers.kit

import java.util.PriorityQueue

fun main() {
    Solution().solution().also { print(it) }

}

private class Solution() {
    fun solution(scovile: IntArray = intArrayOf(1, 2, 3, 9, 10, 12), K: Int = 7): Int {
        var answer = 0
        val pq = PriorityQueue<Int>(scovile.toList())
        while (pq.isNotEmpty()) {
            if (pq.size == 1 && pq.first() < K) break
            val food1 = pq.poll()
            if (food1 >= K) return answer
            val food2 = pq.poll()
            val newFood = food1 + 2 * food2
            pq.add(newFood)
            answer += 1
        }
        return -1
    }
}