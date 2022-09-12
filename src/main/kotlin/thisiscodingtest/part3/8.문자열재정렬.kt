package thisiscodingtest.part3.`8`

import kotlin.math.max

fun main() {
    val input = readln().toList().sorted().also {
        println(it)
    }
    var lastNumberIndex = 0
    for (i in 0..9) {
        lastNumberIndex = max(input.indexOf(i.digitToChar()), lastNumberIndex)
    }
    val sum = input.subList(0, lastNumberIndex + 1).sumOf { it.digitToInt() }
    println(input.subList(lastNumberIndex+1, input.lastIndex+1).joinToString("") + sum.toString())


}

