package thisiscodingtest.part2.c6

import java.util.*
import kotlin.collections.ArrayList

private val array = mutableListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
private val array2 = mutableListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

fun main() {
    selection()
    insertion()
    quick(array, 0, array.lastIndex)
    println(array)
    println(yame_quick(array2))
    counting()
}

private fun selection() {
    val array = ArrayList(array)
    for (i in 0 until array.size) {
        var min_index = i
        for (j in i + 1 until array.size) {
            if (array[min_index] > array[j]) {
                min_index = j
            }
        }
        val temp = array[min_index]
        array[min_index] = array[i]
        array[i] = temp
    }
    println(array)
}

private fun insertion() {
    val array = array.toMutableList()
    for (i in 1 until array.size) {
        for (j in i downTo 1) {
            if (array[j] < array[j - 1]) {
                val temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
            } else {
                break
            }
        }
    }
    println(array)

}

private fun quick(array: MutableList<Int>, start: Int, end: Int) {
    if (start >= end) return // 원소가 1개
    val pivot = start
    var left = start + 1
    var right = end
    while (left <= right) {
        while (left <= end && array[left] <= array[pivot]) // 피벗보다 큰 데이터 찾아야 멈춤
            left += 1
        while (right > start && array[right] >= array[pivot])
            right -= 1
        if (left > right) // 엇갈린 경우
            Collections.swap(array, start, right)
        else
            Collections.swap(array, left, right)
    }
    quick(array, start, right - 1)
    quick(array, right + 1, end)
}

private fun yame_quick(array: MutableList<Int>): MutableList<Int> {
    if (array.size <= 1) return array

    val pivot = array[0]
    val tail = array.subList(1, array.lastIndex + 1)
    val left_side = tail.filter { it <= pivot }.toMutableList()
    val right_side = tail.filter { it > pivot }.toMutableList()

    val result = yame_quick(left_side).apply { add(pivot) }.apply { addAll(yame_quick(right_side)) }

    return result
}

private fun counting() {
    val array = mutableListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8,9,2,2)
    val n = array.let { Collections.max(it) }
    val count = Array(n + 1) { 0 }
    array.forEach {
        count[it] += 1
    }
    count.forEachIndexed { index, cnt ->
        for (i in 1..cnt)
            print("$index ")
    }

}