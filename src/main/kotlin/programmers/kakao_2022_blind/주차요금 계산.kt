package programmers.kakao_2022_blind

import kotlin.math.ceil

private typealias Time = Int

private fun String.convertTime() = this.split(":")
    .let { it[0].toInt() * 60 + it[1].toInt() }

private fun MutableList<Int>.accumulate(): Int {
    if (this.size % 2 == 1)
        this.add("23:59".convertTime())
    var cnt = 0
    for (i in 0 until this.size step 2) {
        cnt += this[i + 1] - this[i]
    }
    return cnt
}

private class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val (defaultTime, defaultFee, unitTime, unitFee) = fees
        val carToTime =
            records.asSequence().map { record -> record.split(" ") }
                .map { it[1].toInt() to it[0].convertTime() }
                .groupBy({ it.first }) { it.second }// 차량번호, 시간들
                .map { it.key to it.value.toMutableList().accumulate() }
                .toMutableList()

        return carToTime
            .sortedBy { it.first }
            .asSequence()
            .map { it.second }
            .map { time ->
                var total = defaultFee
                val remain = time - defaultTime
                if (remain > 0){
                    total += ceil(remain.toDouble() / unitTime).toInt() * unitFee
                }
                 total
            }
            .toList()
            .toIntArray()
    }
}

fun main() {
    Solution().solution(

        intArrayOf(180, 5000, 10, 600),
        arrayOf("05:34 5961 IN", "07:59 5961 OUT")
    )
}