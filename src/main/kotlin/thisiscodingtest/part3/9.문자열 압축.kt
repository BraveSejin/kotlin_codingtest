package thisiscodingtest.part3

import java.util.*
import kotlin.math.min

//https://school.programmers.co.kr/learn/courses/30/lessons/60057
private class Solution {
    fun solution(s: String): Int {
        if (s.length == 1) return 1
        var answer = 1000
        val half = s.length / 2
        for (std in 1..half) {
            val chunks = s.chunked(std)
            val stack = Stack<Pair<Int, String>>()
            for (chunk in chunks) {
                if (stack.isEmpty()) {
                    stack.add(Pair(1, chunk))
                } else if (stack.last().second == chunk) {
                    val (num, str) = stack.pop()
                    stack.add(Pair(num + 1, str))
                } else {
                    stack.add(Pair(1, chunk))
                }
            }
            val compressed = stack.flatMap { it ->
                if (it.first == 1) {
                    listOf(it.second)
                } else {
                    listOf(it.first.toString(), it.second)
                }
            }.joinToString("")
            answer = min(answer, compressed.length)

        }
        return answer
    }
}

fun main() {
    val a = "aa"
//    val a = "aabbaccc"
//    val a = "ababcdcdababcdcd"
    Solution().solution(a).also { print(it) }
}