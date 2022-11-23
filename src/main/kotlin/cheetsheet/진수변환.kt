package cheetsheet

import java.util.*

/**
 * 알고리즘은 구경할만 하지만, 아래 방식으로 하는게 가장 심플함
 * k진수 -> 십진수 에는 "숫자문자열".toInt(radix = 숫자문자열의 진수 k)
 * 십진수 -> k진수 에는 십진수.toString(radix = 변환대상진수 k)
 * a진수 -> b진수
 * "숫자문자열.toInt(radix = a).toString(radix = b)
 */


/**
 * k 진수 n을  10진수로 변환한다.
 * n을 앞쪽부터 읽는다.
 * 처음에 result = 0 으로 설정한다.
 * 아직 읽지 않은 수가 있다면 result에 k를 곱하고 새로 읽은 수를 더한다.
 * 기록한 나머지를 거꾸로 읽으면 변환된 진수이다.
 *
 *
 * */


// "1010".toInt(radix = 3) 이런 식으로 해도 무방함
private fun decimalToK(n: Int, k: Int): String {
    var current = n
    val stack = Stack<Char>()
    while (current != 0) {
        val remainder = current % k
        if (remainder > 9) {
            stack.add((remainder + 55).toChar())
        } else {
            stack.add((remainder + 48).toChar())
        }
        val quotient = current / k
        current = quotient
    }
    return stack.reversed().joinToString("")
}


/**
 * 코틀린에서 지원하는 방법으로 구현한다면
 * k를 [Integer.toHexString] 이런 방법도 있고
 * [Integer.toString(255,16)] -> ff 이런 방법도 있음
 * 255.toString(radix = 16) 과 동치.
 */

private fun kToDecimal(n: String, k: Int): Int {
    var result = 0
    n.map {
        if (it.code in 48..57)
            it.code - 48
        else
            it.code - 55 // 소문자로 다루고싶으면 87로 빼면 된다.
    }.forEach {
        result *= k
        result += it
    }
    return result
}
// k진수를 십진수로 변환
private fun simpleKtoDecimal(i: String, k: Int) {
    i.toInt(radix = k)
}
// 십진수를 k진수 스트링으로 변환
private fun simpleDecimalToK(i: Int, k: Int): String {
    return i.toString(radix = k)
}

private fun convertAtoB(n: String, a: Int, b: Int): String {
    return n.toInt(radix = a).toString(radix = b)
}


fun main() {
    println('A'.code)
    println('a'.code)
    val cur = 30
    val k = 16
    // 십진수를 k진수로 변경하기
    decimalToK(10, 2).also { println(it) }
    decimalToK(10, 3).also { println(it) }
    decimalToK(10, 4).also { println(it) }
    decimalToK(10, 5).also { println(it) }
    decimalToK(10, 6).also { println(it) }
    decimalToK(10, 7).also { println(it) }
    decimalToK(10, 8).also { println(it) }
    decimalToK(10, 9).also { println(it) }
    decimalToK(10, 10).also { println(it) }
    decimalToK(10, 11).also { println(it) }
    decimalToK(12, 11).also { println(it) }
    decimalToK(255, 16).also { println(it) }
    // 10진수인 100을 16진수로 변한
    println(Integer.toHexString(100))
    //10진수 256을 16진수로 변환
    println(256.toString(16))
    println(255.toString(16))

    println()
    kToDecimal("1010", 2).also { println(it) }
    kToDecimal("101", 3).also { println(it) }
    kToDecimal("22", 4).also { println(it) }
    kToDecimal("20", 5).also { println(it) }
    kToDecimal("14", 6).also { println(it) }
    kToDecimal("13", 7).also { println(it) }
    kToDecimal("12", 8).also { println(it) }
    kToDecimal("11", 9).also { println(it) }
    kToDecimal("10", 10).also { println(it) }
    kToDecimal("FF", 16).also { println(it) }
    "FF".toInt(16).also { println(it) }
    //2진수인 1111을 10진수로 변환. 결과 15
    println("1111".toInt(radix = 2))
    // 16진수인 1111을 10진수로 변환. 결과 4369
    println("1111".toInt(radix = 16))
    println(Integer.parseInt("1111", 16))

    // 코틀린 어프로치
    // 특정 진수를 십진수로 바꾸기
    println()

    convertAtoB("ff", 16, 2).also { println(it) }
    convertAtoB("11111111", 2, 16).also { println(it) }
    convertAtoB("11111111", 2, 20).also { println(it) }


    // 16진수인 100을 decimal로 변환


}