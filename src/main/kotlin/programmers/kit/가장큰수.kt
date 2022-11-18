package programmers.kit

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.pow

fun main() {
    solution2(intArrayOf(3, 31, 34, 5, 9)).also { println(it) }
//    solution(intArrayOf(2,0,0)).also { println(it) }
//    solution(intArrayOf(11,12)).also { println(it) }
}

private fun solution(numbers: IntArray): String {
    var answer = numbers.map { it.toString() }.sortedWith { i1, i2 ->
        val s1 = if (i1 == "0") "" +i2 else i1 + i2
        val s2 = if (i2 == "0") ""+ i1 else i2 + i1

        -(s1.toInt() - s2.toInt())

    }.joinToString("")
    if (answer.count { it == '0' }  == answer.length) return "0"
    return answer
}

private fun solution2(numbers: IntArray): String {
    var answer = numbers.sortedWith { i1, i2 ->
        "$i2$i1".compareTo("$i1$i2")
    }.joinToString("")
    if (answer.startsWith('0')) return "0"
    return answer
}