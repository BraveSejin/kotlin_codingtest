package programmers

import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = ArrayDeque<Int>(queue1.toList())
        val q2 = ArrayDeque<Int>(queue2.toList())
        var tot1 = Arrays.stream(queue1).asLongStream().toArray().sum()
        var tot2 = Arrays.stream(queue2).asLongStream().toArray().sum()


        for (i in 0..600010) {
            if (tot1 == tot2) return i
            if (tot1 < tot2) {
                val value = q2.removeFirst()
                q1.addLast(value)
                tot1 += value
                tot2 -= value
            } else {
                val value = q1.removeFirst()
                q2.addLast(value)
                tot2 += value
                tot1 -= value
            }
        }

        return -1
    }
}