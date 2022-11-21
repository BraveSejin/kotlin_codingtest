package cheetsheet

import java.util.*

/**
 * 10진수 미만의 진수변환
 * 숫자로 다 표현되므로 알파벳 관련 처리를 안해서 간단하게 구현할 수 있다.
 * 스트링 빌더의 사용법을 잊었을 때 임기응변으로 사용하면 좋을 것 같다.
 */

/**
 * 10진수 n을 k 진수로 변환한다.
 * n을 k로 더 이상 나눌 수 없을 때까지 나누면서, 나눌 때마다 나머지를 기록한다.
 * 기록한 나머지를 거꾸로 읽으면 변환된 진수이다.
 * */
private fun decimalToK(n: Int, k: Int): Int {
    var current = n
    val stack = Stack<Int>()
    while (current != 0) {
        val remainder = current % k
        stack.add(remainder)
        val quotient = current / k
        current = quotient
    }
    var result = 0
    while (stack.isNotEmpty()) {
        result *= 10
        result += stack.pop()
    }
    return result
}
/**
 * k 진수 n을  10진수로 변환한다.
 * n을 앞쪽부터 읽는다.
 * 처음에 result = 0 으로 설정한다.
 * 아직 읽지 않은 수가 있다면 result에 k를 곱하고 새로 읽은 수를 더한다.
 * 기록한 나머지를 거꾸로 읽으면 변환된 진수이다.
 * */

private fun kToDecimal(n: Int, k: Int): Int {
    var result = 0
    n.toString()
        .map { it.digitToInt() }
        .forEach {
            result *= k
            result += it
        }
    return result
}


fun main() {
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
    println()
    kToDecimal(1010,2).also { println(it) }
    kToDecimal(101,3).also { println(it) }
    kToDecimal(22,4).also { println(it) }
    kToDecimal(20,5).also { println(it) }
    kToDecimal(14,6).also { println(it) }
    kToDecimal(13,7).also { println(it) }
    kToDecimal(12,8).also { println(it) }
    kToDecimal(11,9).also { println(it) }
    kToDecimal(10,10).also { println(it) }
}