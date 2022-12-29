package boj.boj_practice

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val data = BufferedReader(InputStreamReader(System.`in`)).readLine().split(" ").map { it.toInt() }
    var ans = mutableListOf<Int>().apply { addAll(data) }

    for (i in 1 until n){
        ans[i] = max(ans[i], ans[i-1] + data[i])
    }
    println(ans.maxOf { it })
}