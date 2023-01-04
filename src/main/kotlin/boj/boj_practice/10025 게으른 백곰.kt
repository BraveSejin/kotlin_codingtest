package boj.boj_practice

import kotlin.math.max
fun main() {
    val (N,K) = readln().split(" ").map { it.toInt() }
    var array = IntArray(1000001)
    val pos = mutableListOf<Int>()

    repeat(N){
        val (g,x) = readln().split(" ").map { it.toInt() }
        array[x] = g
        pos.add(x)
    }
    val xStart = array.indexOfFirst { it != 0 }
    val xEnd = array.indexOfLast { it != 0 }

    array = array.slice(xStart .. xEnd).toIntArray()

    var ans = 0L
    var sum = 0L
    val targetNum = 2*K +1
    for (idx in array.indices){ // idx가  targetNum - 1 번쨰 인덱스까지는 더하기만 한다. 그 이후는 이전것 제거
        sum += array[idx]
        if (idx >= targetNum)
            sum -= array[idx - targetNum]
        ans = max(ans, sum)

    }

    // 1 ~ 5 , K
    println(ans)
}