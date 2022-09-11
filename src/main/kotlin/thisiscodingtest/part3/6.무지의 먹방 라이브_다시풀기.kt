package thisiscodingtest.part3

import java.util.*

fun main() {

    val res = solution2(intArrayOf(3, 1, 2), 5)
    println(res)
}


private fun solution2(food_times: IntArray, k: Long): Int {

    var (cnt, foodLeft, timeOfPrevFood) = Triple(k, food_times.size, 0)
    val set = (0 until foodLeft).toHashSet()

    food_times.mapIndexed { index, i -> Pair(i, index) }
        .groupBy { it.first }
        .toSortedMap()
        .forEach { sameTimeMap ->
            val timeToEat = foodLeft.toLong() * (sameTimeMap.key - timeOfPrevFood)
            if (cnt < timeToEat) {
                return set.sorted().toList()[(cnt % foodLeft).toInt()] + 1
            } else {
                cnt -= timeToEat
                foodLeft -= sameTimeMap.value.size
                sameTimeMap.value.forEach { set.remove(it.second) }
                timeOfPrevFood = sameTimeMap.key
            }
        }
    return -1
}


/**
 * 아래 코드 분석하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42891/solution_groups?language=kotlin
class Solution {

}
 * */