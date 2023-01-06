package boj.boj_practice

import kotlin.math.max
import kotlin.math.min

fun main() {
    readln().toInt().let {
        repeat(it){
            sol()
        }
    }
}

private fun sol(){
    val str = readln()
    val K = readln().toInt()
    /**
     * 1. 전체 알파벳 문자의 등장 위치를 계산한다 (1만)
     * 2. 전체 알파벳 문자의 구간들을 구한다 (1만정도일듯) 1만개 체크하면 되니까
     * 3. K개 포함되는 가장 짧은 구간을 구한다  1만
     * 4. K개 포함되는 가장 가장 긴 구간을 구한다 (앞뒤는 해당 알파벳으로 끝나야한다) 1만
     * */
    val hmPositions = hashMapOf<Char,MutableList<Int>>()
    str.forEachIndexed { idx, char ->
        if (hmPositions[char] == null)
            hmPositions[char] = mutableListOf()
        hmPositions[char]!!.add(idx)
    }
    var minIntervalLength = 10001
    var maxIntervalLength = 0
    // 3, 4, 총 구간의 개수가 1만개 미만
    for (positionList in hmPositions.values){
        if (positionList.size < K) continue
        // 구간의 길이를 구할 수 있음. K개가 포함된 인터벌의 개수
        val numInterval = positionList.size - K + 1
        for (i in 0 until numInterval){
            val len = positionList[i + (K-1)] - positionList[i] + 1
            minIntervalLength = min(minIntervalLength, len)
            maxIntervalLength = max(maxIntervalLength, len)
        }

    }

    if (maxIntervalLength == 0)
        println(-1)
    else
        println("$minIntervalLength $maxIntervalLength")


}