package boj.`boj-bakctraking`

import kotlin.properties.Delegates

private lateinit var isUsed: BooleanArray
private lateinit var arr: IntArray
private var n by Delegates.notNull<Int>()
private var m by Delegates.notNull<Int>()

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    isUsed = BooleanArray(n + 1)
    arr = IntArray(m + 1)
    // n부터 m까지 자연수 중 중복 없이 m개를 고른 수열
    select(1)


}

private fun select(depth: Int) {
    if (depth == m + 1){
        arr.drop(1).forEach { print("$it ") }
        println()
        return
    }
    for (i in 1..n) {
        if (!isUsed[i]){
            arr[depth] = i
            isUsed[i] = true
            select(depth + 1)
            isUsed[i] = false
        }

    }
}
