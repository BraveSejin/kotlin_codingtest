package programmers.kit

import java.util.*

fun main() {
    solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
        .also { println(it.toList()) }

    sol2(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
        .also { println(it.toList()) }
}

private fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    val progStack = Stack<Int>().apply {
        progresses.reversed().forEach { add(it) }
    }
    val speedStack = Stack<Int>().apply {
        speeds.reversed().forEach { add(it) }
    }
    while (progStack.isNotEmpty()) {

        for (i in 0 .. progStack.lastIndex){
            progStack[i] += speedStack[i]
        }
        var cnt = 0
        while (progStack.isNotEmpty() && progStack.last() >= 100) {
            progStack.pop()
            speedStack.pop()
            cnt += 1
        }
        if (cnt != 0)
            answer.add(cnt)
    }
    return answer.toIntArray()
}

private fun sol2(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()

    var lastDay = 0
    var cnt = 0
    progresses
        .mapIndexed {idx, progress -> Pair(progress, speeds[idx].toDouble())}
        .map { (100 - it.first) / it.second }
        .map { Math.ceil(it).toInt() }
        .forEach { curDay ->
            if (lastDay >= curDay) {
                cnt++
            } else {
                if (lastDay != 0)
                    answer = answer.plus(cnt)
                lastDay = curDay
                cnt = 1
            }
        }
    answer = answer.plus(cnt)

    return answer
}

